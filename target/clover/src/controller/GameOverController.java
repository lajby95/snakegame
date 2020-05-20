/* $$ This file has been instrumented by Clover 4.4.1#2019101123313948 $$ */package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import results.GameResult;
import results.GameResultDao;

import java.io.IOException;
import java.util.List;

public class GameOverController {public static class __CLR4_4_16r6rkadzry31{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_4_1();if(2019101123313948L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.4.1#2019101123313948,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u006c\u0061\u006a\u0062\u0079\u002f\u0044\u0045\u002d\u0049\u004b\u0020\u0032\u0030\u0031\u0039\u002d\u0032\u0030\u002d\u0032\u002f\u0050\u0072\u006f\u0067\u0074\u0065\u0063\u0068\u002f\u0048\u0061\u007a\u0069\u005f\u0070\u0072\u006f\u006a\u0065\u006b\u0074\u002f\u0073\u006e\u0061\u006b\u0065\u0067\u0061\u006d\u0065\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1589897255517L,8589935092L,256,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_4_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

    private GameResult result = new GameResult();

    @FXML
    Text scoreText;

    @FXML
    TextField playerNameInput;

    public void init(GameResult result){try{__CLR4_4_16r6rkadzry31.R.inc(243);
        __CLR4_4_16r6rkadzry31.R.inc(244);this.result = result;
        __CLR4_4_16r6rkadzry31.R.inc(245);scoreText.setText(Integer.toString(result.getScore()));
    }finally{__CLR4_4_16r6rkadzry31.R.flushNeeded();}}

    @FXML
    private void submitResultAndSwitchToMainMenu(ActionEvent event) throws IOException {try{__CLR4_4_16r6rkadzry31.R.inc(246);
        __CLR4_4_16r6rkadzry31.R.inc(247);GameResultDao dao = new GameResultDao();

        __CLR4_4_16r6rkadzry31.R.inc(248);result.setPlayerName(playerNameInput.getText());

        __CLR4_4_16r6rkadzry31.R.inc(249);dao.insertGameResult(result);


        __CLR4_4_16r6rkadzry31.R.inc(250);Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainmenu.fxml"));
        __CLR4_4_16r6rkadzry31.R.inc(251);Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        __CLR4_4_16r6rkadzry31.R.inc(252);stage.setScene(new Scene(root));
        __CLR4_4_16r6rkadzry31.R.inc(253);stage.show();

        __CLR4_4_16r6rkadzry31.R.inc(254);List<GameResult> results = dao.getGameResults(5);
        __CLR4_4_16r6rkadzry31.R.inc(255);results.stream().forEach(System.out::println);
    }finally{__CLR4_4_16r6rkadzry31.R.flushNeeded();}}
}
