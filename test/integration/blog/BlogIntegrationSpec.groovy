package blog

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

import spock.lang.Specification

class BlogIntegrationSpec extends Specification{
    def blog

    @Before
    void init() {
        blog = new Blog()
    }

    private def createPostEntryWithDate(fecha){
        return blog.createPost(pubdate: Date.parse("yyyy-MM-dd", fecha), title: fecha)
    }

    @Test
    void "entries sortered by reverse pubdate"(){
        def oldest = createPostEntryWithDate("2012-01-01")
        def middle = createPostEntryWithDate("2012-02-02")
        def young = createPostEntryWithDate("2012-03-03")
        blog.addToEntries(oldest)
        blog.addToEntries(middle)
        blog.addToEntries(young)

        expect:
        blog.entries == [young, middle, oldest]
    }

    @Test
    void "entries limited to 10"(){
        10.times{
            println "Cargando el post $it"
            blog.addToEntries(createPostEntryWithDate("2010-01-${it+1}"))
        }
        expect:
        blog.entries.size() == 10
        def oldest = createPostEntryWithDate("2008-01-01")
        blog.addToEntries(oldest)
        blog.entries.size() == 10
        !blog.entries.contains(oldest)
    }
}
