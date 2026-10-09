package com.volume_controller.remote_volume_controller.service;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.win32.W32APIOptions;
import org.springframework.stereotype.Service;

@Service
public class VolumeService {

    // Define a custom interface to bridge the missing keybd_event method
    public interface CustomUser32 extends User32 {
        CustomUser32 INSTANCE = Native.load("user32", CustomUser32.class, W32APIOptions.DEFAULT_OPTIONS);
        void keybd_event(byte bVk, byte bScan, int dwFlags, int dwExtraInfo);
    }

    private static final int VK_VOLUME_MUTE = 0xAD;
    private static final int VK_VOLUME_DOWN = 0xAE;
    private static final int VK_VOLUME_UP = 0xAF;

    public static void volumeUp() {
        sendKey((byte) VK_VOLUME_UP);
    }

    public static void volumeDown() {
        sendKey((byte) VK_VOLUME_DOWN);
    }

    public static void mute() {
        sendKey((byte) VK_VOLUME_MUTE);
    }

    private static void sendKey(byte vkCode) {
        // Press and release the key
        CustomUser32.INSTANCE.keybd_event(vkCode, (byte) 0, 0, 0);          // Key down
        CustomUser32.INSTANCE.keybd_event(vkCode, (byte) 0, 2, 0);          // Key up (2 = KEYEVENTF_KEYUP)
    }

}