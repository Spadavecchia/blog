package blog

class BlogSingletonService {
    def blog
    def getInstance() {
        if(!blog){
            blog = new Blog()
            assert !blog.entries
        }
        blog
    }
}
