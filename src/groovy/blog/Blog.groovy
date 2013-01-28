package blog
public class Blog {
    String title = "Watching Paint Dry"
    String subtitle = "The trusted source for drying paint news & opinion"
    private def entryFetcher

    public Blog(Closure entryFetcher){
        this.entryFetcher = entryFetcher
    }

    public Blog(){
        entryFetcher = Post.&getLastest
    }

    def createPost(args){
        def post = getPostSource(args)
        post.blog = this
        return post
    }

    def getEntries(){
        return fetchEntries()
    }

    def addToEntries(entry){
        entry.save()
    }

    def fetchEntries(){
        println "${entryFetcher.getClass()}"
        return entryFetcher()
    }

    private def getPostSource(args){
        return new Post(args)
    }
}
