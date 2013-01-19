package blog

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*
import spock.lang.Specification

@TestFor(Post)
class PostSpec extends Specification{
    def obj
    def blog

    void setup() {
        obj = new Post(title: "TITULO")
        blog = Mock(Blog)
    }

    def "el absurdo test que prueba que todo inicia en nulo"(){
        expect:
        obj.title
        !obj.body
        !obj.pubdate
    }

    def "otro absurdo test para probar que se asigna el blog al post"(){
        obj.blog = blog
        expect:
        obj.blog == blog
    }

    def "cuando se publica el post se agrega a entries del blog"(){
        obj.blog = blog
        when:
        obj.publish()

        then:
        1 * blog.addToEntries(obj)
    }

    def "se crea un nuevo post con argumentos"(){
        def post = new Post([title: "Titulo", body: "Body"])

        expect:
        post.body == "Body"
    }

    def "un post instancia su pubdate en el momento en el que ejecuta publish"(){
        Date now = new Date()
        obj.blog = blog

        when:
        obj.publish now

        then:
        1 * blog.addToEntries(obj)

        expect:
        obj.pubdate instanceof Date
        obj.pubdate == now
    }

    def "no puede publicarse un post con title null"(){
        obj.blog = blog

        when:
        obj.title = title

        then:
        obj.publish() == valid

        where:
        title | valid
        null | false
        "algo" | true
        "" | false
    }

    def "hasPicture is true when post has imageUrl and false when not"(){
        when:
        obj.imageUrl = image

        then:
        obj.hasPicture() == hasPicture

        where:
        image | hasPicture
        null  | false
        "x"   | true
    }
}
