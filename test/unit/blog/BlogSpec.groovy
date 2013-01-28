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
        def entries = []
        blog = new Blog({-> entries})
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
        when:
        blog.addToEntries(post)

        then:
        1 * post.save()
    }
}
