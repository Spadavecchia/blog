package blog

class TextPostExhibit extends Exhibit{
    TextPostExhibit(post, context)  {super(post, context)}

    protected String getTemplatePath(){
        return "/post/textBody"
    }

    static Boolean isApplicableTo(model){
        return model instanceof Post && !model.hasPicture()
    }
}
