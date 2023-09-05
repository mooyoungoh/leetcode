public class Codec {

    //    5/Hello5/World

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        var sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        var ans = new ArrayList<String>();
        int i = 0;
        while(i < s.length()){
            int slash = s.indexOf('/', i);
            int size = Integer.parseInt(s.substring(i, slash));
            i = slash + 1 + size;
            ans.add(s.substring(slash + 1, i));
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));