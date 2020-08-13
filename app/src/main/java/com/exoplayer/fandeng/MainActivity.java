package com.exoplayer.fandeng;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoListener;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.exoplayer.fandeng.databinding.ActivityMainBinding;
import com.exoplayer.lib.base.ui.DataBindingActivity;

/**
 * @author zhangshuai
 */
public class MainActivity extends DataBindingActivity<ActivityMainBinding> {

    private SimpleExoPlayer mExoPlayer;


    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        //创建播放器
        mExoPlayer=new SimpleExoPlayer.Builder(this).build();
        //创建媒体
        DataSource.Factory factory=new DefaultDataSourceFactory(this, Util.getUserAgent(this,"ExoPlayer-android"));
        //
        MediaSource videoSource=new ProgressiveMediaSource.Factory(factory).createMediaSource(Uri.parse(""));

        mExoPlayer.prepare(videoSource);


        mExoPlayer.addListener(new Player.EventListener() {
            @Override
            public void onTimelineChanged(final Timeline timeline, final int reason) {

            }

            @Override
            public void onTracksChanged(final TrackGroupArray trackGroups,
                                        final TrackSelectionArray trackSelections) {

            }

            @Override
            public void onLoadingChanged(final boolean isLoading) {

            }

            /**
             * Player.STATE_IDLE：这是初始状态，即播放器停止和播放失败时的状态。
             * Player.STATE_BUFFERING：播放器无法立即从其当前位置播放。这主要是因为需要加载更多数据。
             * Player.STATE_READY：播放器可以立即从其当前位置播放。
             * Player.STATE_ENDED：播放器播放完所有媒体。
             * @param playWhenReady
             * @param playbackState
             */
            @Override
            public void onPlayerStateChanged(final boolean playWhenReady, final int playbackState) {
            }

            @Override
            public void onPlaybackSuppressionReasonChanged(final int playbackSuppressionReason) {

            }

            @Override
            public void onIsPlayingChanged(final boolean isPlaying) {
                if (isPlaying) {
                    // Active playback.
                } else {
                    // Not playing because playback is paused, ended, suppressed, or the player
                    // is buffering, stopped or failed. Check player.getPlaybackState,
                    // player.getPlayWhenReady, player.getPlaybackError and
                    // player.getPlaybackSuppressionReason for details.
                }
            }

            @Override
            public void onRepeatModeChanged(final int repeatMode) {

            }

            @Override
            public void onShuffleModeEnabledChanged(final boolean shuffleModeEnabled) {

            }

            @Override
            public void onPlayerError(final ExoPlaybackException error) {

            }

            @Override
            public void onPositionDiscontinuity(final int reason) {

            }

            @Override
            public void onPlaybackParametersChanged(final PlaybackParameters playbackParameters) {

            }

            @Override
            public void onSeekProcessed() {

            }
        });


        mExoPlayer.addVideoListener(new VideoListener() {
            @Override
            public void onVideoSizeChanged(final int width, final int height, final int unappliedRotationDegrees, final float pixelWidthHeightRatio) {
            }

            @Override
            public void onSurfaceSizeChanged(final int width, final int height) {

            }

            @Override
            public void onRenderedFirstFrame() {

            }
        });

    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mExoPlayer != null) {
            mExoPlayer.release();
            mExoPlayer=null;
        }
    }
}
