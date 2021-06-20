package codility;

public class T2 {
    public static String solution(String S) {
        String[] files = S.split("\\n");
        int min = 300;
        for (int i = 0; i < files.length; i++) {
            String[] parts = files[i].trim().split(" ");
            if (!"root".equals(parts[0])) continue;
            if (!"r--".equals(parts[1])) continue;
            String extension = parts[2].substring(parts[2].lastIndexOf('.') + 1);
            System.out.println(extension);
            if ("doc".equals(extension) || "xls".equals(extension) || "pdf".equals(extension)){
                min = Math.min(min, parts[2].length());
            }
        }
        if (min == 300){
            return "NO FILES";
        }else{
            return String.valueOf(min);
        }
    }

    public static void main(String[] args) {
        String S = "root r-x delete-this.xls\n"
            + "  root r-- bug-report.pdf\n"
            + "  root r-- doc.xls\n"
            + "  root r-- podcast.flac\n"
            + " alice r-- system.xls\n"
            + "  root --x invoices.pdf\n"
            + " admin rwx SETUP.PY";
        System.out.println(solution(S));
    }
}
