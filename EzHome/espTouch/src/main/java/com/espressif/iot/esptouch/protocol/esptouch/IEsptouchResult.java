package com.espressif.iot.esptouch.protocol.esptouch;

public interface IEsptouchResult {
	boolean isSuc();
	String getBssid();
	boolean isCancelled();
}
