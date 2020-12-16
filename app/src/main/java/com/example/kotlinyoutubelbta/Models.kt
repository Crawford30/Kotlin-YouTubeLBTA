package com.example.kotlinyoutubelbta

//"id": 3,
//"name": "Kindle Basic Training",
//"link": "https://www.letsbuildthatapp.com/basic-training",
//"imageUrl": "https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/114bec2f-fbfd-4b13-91de-907fe57c6e37",
//"numberOfViews": 7500,
//"channel": {
//    "name": "Lets Build That App",
//    "profileImageUrl": "https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/dda5bc77-327f-4944-8f51-ba4f3651ffdf",
//    "numberOfSubscribers": 100000
//}


//class model for data
class HomeFeed(val videos: List<Video>)

class Video(val id: Int, val name: String, val link: String, val imageUrl:String, val numberOfViews: Int,
            val channel: Channel)

class Channel(val name: String, val profileImageUrl:String)



//model objects
class CourseLesson(val name: String, val duration: String, val number: Int, val imageUrl: String, val link: String )
//{
//    "name": "Firebase SDK and User Registration",
//    "duration": "17:34",
//    "number": 3,
//    "imageUrl": "https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/ef96b470-785c-4fed-bad7-d2cc972932fd_thumbnail",
//    "link": "https://www.letsbuildthatapp.com/course_video?id=1042"
//}