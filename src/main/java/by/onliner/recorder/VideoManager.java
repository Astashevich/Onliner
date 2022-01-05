package by.onliner.recorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VideoManager {

    private static final ThreadLocal<VideoRecorder> threadRecorder = new ThreadLocal<>();

    protected static final Logger logger = LogManager.getLogger(VideoManager.class);

    public static VideoRecorder getVideoRecorder() {
        if (threadRecorder.get() == null) {
            getNewRecorder();
        }
        return threadRecorder.get();
    }

    public static void setDefaultRecorder(VideoRecorder recorder) {
        threadRecorder.set(recorder);
    }

    /**
     * Close default recorder
     */
    public static void stopDefaultRecording(String name) {
        VideoRecorder current = threadRecorder.get();
        if (current != null) {
            current.stopRecording(name);
        }
        threadRecorder.set(null);
    }

    private static VideoRecorder getNewRecorder() {
        logger.debug("Create new instance of Recorder");
        VideoRecorder recorder = new VideoRecorder();
        threadRecorder.set(recorder);
        return recorder;
    }
}
