import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
    // genres : ["classic", "pop", "classic", "classic", "pop"]
	// plays : [500, 600, 150, 800, 2500]
        Map<String, Integer> genreMap = new HashMap<>(); // 장르별 재생 수 합산
        Map<String, List<int[]>> songMap = new HashMap<>(); // 장르별 곡 정보(재생 수, 인덱스) 저장

        // 장르별 재생 수 합산 및 곡 정보 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            // 0: "classic"
			// 1: "pop"
            // 2: "classic"
            // 3: "classic"
            // 4: "pop"
            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + plays[i]);
            // i = 0: "classic" → 500 (0 + 500)
            // i = 1: "pop" → 600 (0 + 600)
            // i = 2: "classic" → 650 (500 + 150)
            // i = 3: "classic" → 1450 (650 + 800)
            // i = 4: "pop" → 3100 (600 + 2500)
            // genreMap : {"classic": 1450, "pop": 3100}
            
            // 현재 장르에 대한 리스트가 없으면 새 리스트를 추가
            songMap.putIfAbsent(genre, new ArrayList<>());
            songMap.get(genre).add(new int[]{plays[i], i}); // [재생 수, 인덱스]
        }
        	// i = 0: "classic" → [[500, 0]]
            // i = 1: "pop" → [[600, 1]]
            // i = 2: "classic" → [[500, 0], [150, 2]]
            // i = 3: "classic" → [[500, 0], [150, 2], [800, 3]]
            // i = 4: "pop" → [[600, 1], [2500, 4]]
            // songMap : {"classic": [[500, 0], [150, 2], [800, 3]], "pop": [[600, 1], [2500, 4]]}
            
        // 장르를 재생 수에 따라 정렬
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genreMap.entrySet());
        // genreMap의 엔트리 세트를 리스트로 변환하여 genreList에 저장
		// genreList : [("classic", 1450), ("pop", 3100)]

        genreList.sort((a, b) -> b.getValue().compareTo(a.getValue())); // 내림차순 정렬
        // genreList : [("pop", 3100), ("classic", 1450)]

        List<Integer> answerList = new ArrayList<>();

        // 각 장르에서 가장 많이 재생된 곡의 인덱스 찾기
        for (Map.Entry<String, Integer> entry : genreList) {
            String genre = entry.getKey(); // 첫 번째 반복: "pop", 두 번째 반복: "classic"
            List<int[]> songs = songMap.get(genre);
            songs.sort((a, b) -> b[0] - a[0]); // 재생 수에 따라 내림차순 정렬
            // 첫 번째 반복: "pop" 정렬 후 songs = [[2500, 4], [600, 1]]
			// 두 번째 반복: "classic" 정렬 후 songs = [[800, 3], [500, 0], [150, 2]]
            // 최대 2개의 인덱스 추가
            answerList.add(songs.get(0)[1]); // 첫 번째
            if (songs.size() > 1) {
                answerList.add(songs.get(1)[1]); // 두 번째
            }
        }

        // 결과를 정수 타입 배열로 변환
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}