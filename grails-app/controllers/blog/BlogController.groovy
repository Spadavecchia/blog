package blog

class BlogController {
    def blogSingletonService
    def index() {redirect action: "show"}
    def show(){
        def blogInstance = blogSingletonService.instance
        [blogInstance: blogInstance]
    }
}
