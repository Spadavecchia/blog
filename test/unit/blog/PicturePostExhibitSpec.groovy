package blog

import grails.test.mixin.*
import org.junit.*
import spock.lang.Specification

class PicturePostExhibitSpec extends Specification{

    def post
    def context
    def obj
    
    @Before
    void setup(){
        post = new Post(title: "TITLE", body: "BODY", pubdate: "PUBDATE")
        context = new Expando()
        context.render = {Map map -> return "HTML"}
        obj = new PicturePostExhibit(post, context)
    }

    def "delegates method calls to post"(){
        expect:
        obj.title == post.title
        obj.body == post.body
        obj.pubdate == post.pubdate
    }

    def "context render itself"(){
        expect:
        obj.render() == "HTML"
    }
}
