public class Common {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        for (char ch : words[0].toCharArray()) {
            boolean presentInAll = true;

            for (int i = 1; i < words.length; i++) {
                if (words[i].indexOf(ch) == -1) {
                    presentInAll = false;
                    break;
                }
            }

            if (presentInAll) {
                result.add(String.valueOf(ch));
                for (int i = 1; i < words.length; i++) {
                    words[i] = words[i].replaceFirst(String.valueOf(ch), "");
                }
            }
        }

        return result;
    }
}