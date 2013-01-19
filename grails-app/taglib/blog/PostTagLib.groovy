package blog

class PostTagLib {

    def exhibitFactoryService

	static namespace = "blog"

	def entry = { attrs ->
		def post = exhibitFactoryService.getExhibit(attrs.post, this)
		out << post.render()
	}
}
