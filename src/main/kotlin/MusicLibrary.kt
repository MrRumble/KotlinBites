class MusicLibrary(
    var libraryList: ArrayList<Track> = ArrayList()
) {
    fun getTrack(number: Int): Track?{
        if (libraryList.isEmpty()){ return null }
        return libraryList[number - 1]
    }

    fun addTrack(track: Track): Unit{
        libraryList.add(track)
    }
}