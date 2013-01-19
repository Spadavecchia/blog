package blog

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*
import spock.lang.Specification

@TestMixin(GrailsUnitTestMixin)
class BlogSpec extends Specification{
    def blog
    def post

    @Before
    void setup() {
        blog = new Blog()
        post = GroovyMock(Post)
        blog.metaClass.getPostSource = {args -> return post}
    }

    def "al crearse el blog se inicializa con un List vacio"(){
        expect:
        blog.entries.size() == 0
    }

    def "create post enlaza la instancia de post con el blog"(){
        when:
        blog.createPost()

        then:
        1 * post.setBlog(blog)
    }

    def "you can create post with arguments"(){
        when:
        blog.createPost([title: "titulo", body: "body"])

        then:
        1 * post.setBlog(blog)
    }

    @Test
    void "addToEntries add a post role to entries"(){
        blog.addToEntries(post)
        expect:
        blog.entries.contains(post)
    }

    private def createStubEntryWithDate(fecha){
        new Expando(pubdate: Date.parse("yyyy-MM-dd", fecha))
    }


    @Test
    void "entries sortered by reverse pubdate"(){
        def oldest = createStubEntryWithDate("2012-01-01")
        def middle = createStubEntryWithDate("2012-02-02")
        def young = createStubEntryWithDate("2012-03-03")
        blog.addToEntries(oldest)
        blog.addToEntries(middle)
        blog.addToEntries(young)

        expect:
        blog.entries == [young, middle, oldest]
    }

    @Test
    void "entries limited to 10"(){
        10.times{
            blog.addToEntries(createStubEntryWithDate("2010-01-${it+1}"))
        }
        expect:
        blog.entries.size() == 10
        def oldest = createStubEntryWithDate("2008-01-01")
        blog.addToEntries(oldest)
        blog.entries.size() == 10
        !blog.entries.contains(oldest)
    }
}
