package blog

abstract class Exhibit{
    @Delegate private final Post delegate
    private final context

    def static final exhibits = [
        PicturePostExhibit, 
        TextPostExhibit
    ]

    def static getExhibit(model, context){
        exhibits.inject(model, {object, exhibit ->
            exhibit.exhibitIfApplicable(exhibit, object, context)
        })
    }

    def static exhibitIfApplicable(exhibit, model, context){
        if(exhibit.isApplicableTo(model)){
            return exhibit.newInstance(model, context)
        }
        else{
            return model
        }
    }

    static Boolean isApplicableTo(model){
        return false
    }

    Exhibit(post, context){
        this.delegate = post
        this.context = context
    }

    protected abstract String getTemplatePath()

    def render(){
        return context.render(template: templatePath, post: this)
    }
}
