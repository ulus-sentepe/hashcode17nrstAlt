package com.onurusta.hashcode2017;


public class CachableVideoItem implements Comparable<CachableVideoItem> {

	public int videoNo;
	public int videoSize;
	public long videoValue;

	public CachableVideoItem(int videoNo, int videoSize, long videoValue) {
		super();
		this.videoNo = videoNo;
		this.videoSize = videoSize;
		this.videoValue = videoValue;
	}

	public void increase(long videoValue2) {
		this.videoValue = this.videoValue + videoValue2;

	}

	@Override
	public int compareTo(CachableVideoItem o) {
		return Long.compare(o.videoValue, this.videoValue);
	}

}
