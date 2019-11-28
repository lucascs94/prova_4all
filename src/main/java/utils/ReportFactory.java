package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.core.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import setup.TestRule;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportFactory {
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extentReport;
    private static ExtentTest extentTest;
    private static String diretorioReport;
    private static WebDriver driver;

    public static void criarReport(Scenario cenario) {
        driver = TestRule.getDriver();
        if (extentReport == null) {
            extentReport = new ExtentReports();
            String filename = cenario.getName().replace(" ", "_") + new SimpleDateFormat("_yyyy_MM_dd_HH_m_ss").format(new Date());
            MetodosAuxiliares.criarDiretorio(System.getProperty("user.dir") + "\\reports");
            setDiretorioReport(System.getProperty("user.dir") + "\\reports\\" + filename);
            MetodosAuxiliares.criarDiretorio(diretorioReport);
            htmlReporter = new ExtentHtmlReporter(diretorioReport + "\\report.html");
            extentReport.attachReporter(htmlReporter);
        }
        extentTest = extentReport.createTest(cenario.getName());
    }

    public static void atualizaReport(Scenario cenario) {
        if (cenario.isFailed()) {
            extentTest.log(Status.ERROR, "Erro encontrado durante a execução.");
        } else {
            extentTest.log(Status.PASS, "Cenário executado com sucesso.");
        }
        extentReport.flush();
    }

    private static void setDiretorioReport(String diretorio) {
        diretorioReport = diretorio;
    }

    private static String getDiretorioReport() {
        return diretorioReport;
    }

    private static String getScreenshotReport() {
        String dir = System.getProperty("user.dir");
        driver.getCurrentUrl();
        String nomePrint = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Thread.sleep(1000);
            String diretorioReport = getDiretorioReport();
            MetodosAuxiliares.criarDiretorio(diretorioReport + "\\Screenshots");
            dir = diretorioReport + "\\Screenshots" + "\\" + nomePrint + ".png";
            MetodosAuxiliares.copyFileUsingStream(scrFile, new File(dir));
            dir = ".\\Screenshots" + "\\" + nomePrint + ".png";
        } catch (Exception e) {
            logMensagemFalha("Erro ao salvar o Screenshot - " + e);
        }
        return dir;
    }

    public static void logMensagemInfoPrint(String mensagem) {
        try {
            System.out.println(mensagem);
            extentTest.log(Status.INFO, mensagem,
                    MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotReport()).build());
            extentReport.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logMensagemErroPrint(String mensagem) {
        try {
            System.out.println(mensagem);
            extentTest.log(Status.ERROR, mensagem,
                    MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotReport()).build());
            extentReport.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logMensagemFalhaPrint(String mensagem) {
        try {
            System.out.println(mensagem);
            extentTest.log(Status.FAIL, mensagem,
                    MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotReport()).build());
            extentReport.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logMensagemSucessoPrint(String mensagem) {
        try {
            System.out.println(mensagem);
            extentTest.log(Status.PASS, mensagem,
                    MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotReport()).build());
            extentReport.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logMensagemInfo(String mensagem) {
        System.out.println(mensagem);
        extentTest.log(Status.INFO, mensagem);
        extentReport.flush();
    }

    public static void logMensagemFalha(String mensagem) {
        System.out.println(mensagem);
        extentTest.log(Status.FAIL, mensagem);
        extentReport.flush();
    }

    public static void logMensagemErro(String mensagem) {
        System.out.println(mensagem);
        extentTest.log(Status.ERROR, mensagem);
        extentReport.flush();
    }
}
