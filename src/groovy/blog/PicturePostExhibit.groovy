package blog

class PicturePostExhibit extends Exhibit{
    PicturePostExhibit(post, context)  {super(post, context)}

    protected String getTemplatePath(){
        return "/post/pictureBody"
    }

    static Boolean isApplicableTo(model){
        return model instanceof Post && model.hasPicture()
    }
}
