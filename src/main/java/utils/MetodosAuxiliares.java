package utils;

import java.io.*;

class MetodosAuxiliares {
    static void criarDiretorio(String nomeDiretorio) {
        try {
            File diretorio = new File(nomeDiretorio);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }
        } catch (Exception e) {
            ReportFactory.logMensagemErro(e.getMessage());
        }
    }

    static void copyFileUsingStream(File source, File dest) throws IOException {
        try (InputStream is = new FileInputStream(source); OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }
}
