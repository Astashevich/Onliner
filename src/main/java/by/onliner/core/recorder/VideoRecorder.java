package by.onliner.core.recorder;

import by.onliner.core.driver.DriverManager;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import ws.schild.jave.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static by.onliner.constants.OnlinerConstants.SAVE_VIDEO_PATH;
import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

/***
 * The class is used to record screen and convert video to mp4 format.
 */
public class VideoRecorder {

    private ScreenRecorder screenRecorder;

    private static final String CODEC_LIBX264 = "libx264";
    private static final int BITRATE = 3200000;
    private static final int FRAMERATE = 15;
    private static final String FORMAT_MP4 = "mp4";
    private static final int DEPTH = 24;
    private static final int RATIONAL_15 = 15;
    private static final float QUALITY = 1.0f;
    private static final int FRAME_INTERVAL = 15 * 60;
    private static final String ENCODING = "black";
    private static final int RATIONAL_30 = 30;
    private static final String STORE_FORMAT_MP4 = ".mp4";

    /***
     * Initialise recorder and start recording test
     * @param name method name
     */
    public void startRecording(String name) {
        try {
            File file = new File(SAVE_VIDEO_PATH);

            Point point = DriverManager.getDriver().manage().window().getPosition();
            Dimension dimension = DriverManager.getDriver().manage().window().getSize();

            Rectangle captureSize = new Rectangle(point.x, point.y, dimension.width, dimension.height);

            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
                    getDefaultScreenDevice()
                    .getDefaultConfiguration();

            screenRecorder = new Recorder(gc, captureSize,
                    new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, DEPTH, FrameRateKey,
                            Rational.valueOf(RATIONAL_15), QualityKey, QUALITY, KeyFrameIntervalKey, FRAME_INTERVAL),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING, FrameRateKey, Rational.valueOf(RATIONAL_30)),
                    null, file, name);

            screenRecorder.start();
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }

    /***
     * Stoped recording test
     * @param name method name
     */
    public void stopRecording(String name) {
        try {
            screenRecorder.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
        aviToMp4(name);
    }


    /***
     * Converts avi to mp4 video format
     */
    private void aviToMp4(String name) {
        File lastVideoFile = screenRecorder.getCreatedMovieFiles().get(screenRecorder.getCreatedMovieFiles().size()-1);
        File source = new File(lastVideoFile.getAbsolutePath());
        File target = new File(SAVE_VIDEO_PATH + name + STORE_FORMAT_MP4);
        VideoAttributes video = new VideoAttributes();
        video.setCodec(CODEC_LIBX264);
        video.setBitRate(BITRATE);
        video.setFrameRate(FRAMERATE);
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat(FORMAT_MP4);
        attrs.setVideoAttributes(video);
        Encoder encoder = new Encoder();
        MultimediaObject multimediaObject = new MultimediaObject(source);
        try {
            encoder.encode(multimediaObject, target, attrs);
        } catch (IllegalArgumentException | EncoderException e) {
            e.printStackTrace();
        }
    }
}
