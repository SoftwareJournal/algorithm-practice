class MaximumNumberOfWords {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        int count = 0;
        for(String item : sentences){
            String[] words = item.split(" ");
            count = words.length;
            if(count > max){
                max = count;
            }
        }
        return max;
    }
}