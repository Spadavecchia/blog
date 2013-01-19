package blog
public class Blog {
    String title = "Watching Paint Dry"
    String subtitle = "The trusted source for drying paint news & opinion"
    private def entries = []

    def createPost(args){
        def post = getPostSource(args)
        post.blog = this
        post
    }

    def getEntries(){
        entries.sort{it.pubdate}.reverse().take(10)
    }

    def addToEntries(entry){
        entries << entry
    }

    private def getPostSource(args){
        new Post(args)
    }
}
