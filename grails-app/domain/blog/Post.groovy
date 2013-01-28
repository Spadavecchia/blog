package blog

class Post{
    def blog
    String title
    String body
    Date pubdate
    String imageUrl

    def publish(Date now = null){
        if(!this.validate()){
            this.errors.allErrors.each{println it}
            return false
        }

        this.pubdate = now ?: new Date()
        blog.addToEntries(this)
        return true
    }

    static def getLastest(max = 10){
        return Post.list([max: max, sort: "pubdate", order: "desc"])
    }

    static constraints = {
        title nullable: false, blank: false
        body nullable: true, blank: true, widget: "textarea"
        pubdate nullable: true, hide: true
        imageUrl nullable: true
        //blog nullable: true
    }

    def hasPicture(){
        return imageUrl != null
    }

    String toString(){
        return title
    }
}
