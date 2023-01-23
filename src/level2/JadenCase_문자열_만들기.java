package src.level2;

class JadenCase_문자열_만들기 {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("")) {
                sb.append(" ");
                continue;
            }

            str[i] = str[i].toLowerCase();
            char first = str[i].charAt(0);

            if (first >= 'a' && first <= 'z') {
                first = (char) (first + ('A' - 'a'));
            }
            str[i] = first + str[i].substring(1);
            sb.append(str[i] + " ");
        }
        answer = sb.toString().trim();
        if (s.substring(s.length()-1).equals(" ")){
            answer += " ";
        }
        return answer;
    }
}
