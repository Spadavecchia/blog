package blog
import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification

@TestFor(BlogSingletonService)
class BlogSingletonServiceSpec extends Specification {

    def "get a singleton blog from service"(){
        def blog = Mock(Blog)
        service.blog = blog
        when: 
        (0..10).each{service.instance}

        then:
        0 * blog.entries
    }
}
