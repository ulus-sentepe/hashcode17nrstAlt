package com.onurusta.hashcode2017;

import java.util.HashMap;
import java.util.Map;

public class EndPoint {
	public int DClatency;
	public Map<Integer, Integer> cacheValueMap;

	public EndPoint(int dClatency) {
		super();
		this.DClatency = dClatency;
		this.cacheValueMap = new HashMap<Integer, Integer>();
	}

	public void addCacheLink(int cacheNo, int cacheLatency) {
		this.cacheValueMap.put(cacheNo, this.DClatency - cacheLatency);

	}
}
