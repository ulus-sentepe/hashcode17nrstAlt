package com.onurusta.hashcode2017;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProblemDefinition {

	// V ​ ( 1 ≤ V ≤ 10000) - the number of videos
	public static int V;
	// E ( 1 ≤ E ≤ 1000) - the number of endpoints
	public static int E;
	// R ( 1 ≤ R ≤ 1000000) - the number of request descriptions
	public static int R;
	// C ( 1 ≤ C ≤ 1000) - the number of cache servers
	public static int C;
	// X ( 1 ≤ X ≤ 500000) - the capacity of each cache server in megabytes
	public static int X;

	public static int[] videoSizes;
	public static Cache[] caches;
	public static EndPoint[] endPoints;

	public ProblemDefinition(Stream<String> stream) {
		// Parsing
		List<String> list = stream.collect(Collectors.toList());
		int lineNumber = 0;
		String[] sList = list.get(lineNumber++).split(" ");
		V = Integer.parseInt(sList[0]);
		E = Integer.parseInt(sList[1]);
		R = Integer.parseInt(sList[2]);
		C = Integer.parseInt(sList[3]);
		X = Integer.parseInt(sList[4]);

		videoSizes = new int[V];
		sList = list.get(lineNumber++).split(" ");
		for (int i = 0; i < V; i++) {
			videoSizes[i] = Integer.parseInt(sList[i]);
		}

		caches = new Cache[C];
		for (int i = 0; i < C; i++) {
			caches[i] = new Cache(X);
		}

		endPoints = new EndPoint[E];
		for (int i = 0; i < E; i++) {
			sList = list.get(lineNumber++).split(" ");
			endPoints[i] = new EndPoint(Integer.parseInt(sList[0]));
			int cacheCount = Integer.parseInt(sList[1]);
			for (int j = 0; j < cacheCount; j++) {
				sList = list.get(lineNumber++).split(" ");
				int cacheNo = Integer.parseInt(sList[0]);
				int cacheLatency = Integer.parseInt(sList[1]);
				endPoints[i].addCacheLink(cacheNo, cacheLatency);
			}
		}

		// PARSING REQUESTS
		for (int i = 0; i < R; i++) {
			sList = list.get(lineNumber++).split(" ");
			int videoNo = Integer.parseInt(sList[0]);
			int endPointNo = Integer.parseInt(sList[1]);
			int requestCount = Integer.parseInt(sList[2]);
			int videoSize = videoSizes[videoNo];
			EndPoint endPoint = endPoints[endPointNo];
			for (int cacheNo : endPoint.cacheValueMap.keySet()) {
				Cache cache = caches[cacheNo];
				cache.enrollVideo(videoNo, videoSize, (requestCount * endPoint.cacheValueMap.get(cacheNo)) / videoSize);
			}
		}

	}
}
