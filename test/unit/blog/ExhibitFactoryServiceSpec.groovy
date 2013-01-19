package blog

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification

@TestFor(ExhibitFactoryService)

class ExhibitFactoryServiceSpec extends Specification {

    def "decorate picture post with a PicturePostExhibit"(){
        when:
        def post = Mock(Post)
        post.metaClass.hasPicture = { -> true}
        then:
        service.getExhibit(post, new Object()) instanceof PicturePostExhibit
    }

    def "decorate text post with a TextPostExhibit"(){
        when:
        def post = Mock(Post)
        post.metaClass.hasPicture = { -> false}
        then:
        service.getExhibit(post, new Object()) instanceof TextPostExhibit
    }

    def "no regresa exhibits de lo que no conoce"(){
        when:
        def model = new Object()
        then:
        service.getExhibit(model, new Object()) == model
    }
}
