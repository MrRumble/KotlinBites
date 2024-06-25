import kotlin.test.Test

class TestMusicLibrary {
    @Test
    fun testMusicLibrary0returnsNull(){
        val library = MusicLibrary()
        val result = library.getTrack(0)
        assert(result == null)
    }

    @Test
    fun testMusicLibrary1returnsTrack(){
        val library = MusicLibrary()
        val track = Track("title", "artist", 230)
        library.addTrack(track)
        val result = library.getTrack(1)
        assert(result == track)
    }

    @Test
    fun testMusicLibrary2returnsTrack2(){
        val library = MusicLibrary()
        val track = Track("title", "artist", 230)
        val track2 = Track("title2", "artist", 230)
        library.addTrack(track)
        library.addTrack(track2)
        val result = library.getTrack(2)
        assert(result == track2)
    }

}