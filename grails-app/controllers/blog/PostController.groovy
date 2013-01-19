package blog

class PostController {
    def blogSingletonService

    def create(){
        def blog = blogSingletonService.instance
        switch(request.method){
            case 'GET':
                [postInstance: blog.createPost()]
                break
            case 'POST':
                def postInstance = blog.createPost(params)
                if(postInstance.publish()){
                    flash.message = message(code: 'default.created.message', 
                        args: [message(code: 'post.label', default: 'Post'), postInstance.id])
                    redirect controller: "blog", action: "show"
                }
                else{
                    render view: "create", model: [postInstance: postInstance]
                }
                break
        }
    }
}
