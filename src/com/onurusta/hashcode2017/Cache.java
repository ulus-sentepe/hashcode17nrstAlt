package com.onurusta.hashcode2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cache {

	public int capacity;
	public Map<Integer, CachableVideoItem> map;
	public List<Integer> results;

	public Cache(int capacity) {
		super();
		this.capacity = capacity;
		this.map = new HashMap<Integer, CachableVideoItem>();
	}

	public void enrollVideo(int videoNo, int videoSize, long videoValue) {
		if (this.map.containsKey(videoNo)) {
			this.map.get(videoNo).increase(videoValue);
		} else {
			CachableVideoItem cvi = new CachableVideoItem(videoNo, videoSize, videoValue);
			this.map.put(videoNo, cvi);
		}

	}

	public void solve() {
		this.results = new ArrayList<Integer>();
		List<CachableVideoItem> list = new ArrayList<CachableVideoItem>(this.map.values());
		Collections.sort(list);

		for (CachableVideoItem cachableVideoItem : list) {
			if (this.capacity >= cachableVideoItem.videoSize) {
				this.capacity = this.capacity - cachableVideoItem.videoSize;
				this.results.add(cachableVideoItem.videoNo);
			}
		}

	}
}
