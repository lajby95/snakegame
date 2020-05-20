/* $$ This file has been instrumented by Clover 4.4.1#2019101123313948 $$ */package controller;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.extern.slf4j.Slf4j;
import results.GameResult;
import snake.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
public class GameController implements Initializable {public static class __CLR4_4_100kadzrxyh{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_4_1();if(2019101123313948L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.4.1#2019101123313948,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u006c\u0061\u006a\u0062\u0079\u002f\u0044\u0045\u002d\u0049\u004b\u0020\u0032\u0030\u0031\u0039\u002d\u0032\u0030\u002d\u0032\u002f\u0050\u0072\u006f\u0067\u0074\u0065\u0063\u0068\u002f\u0048\u0061\u007a\u0069\u005f\u0070\u0072\u006f\u006a\u0065\u006b\u0074\u002f\u0073\u006e\u0061\u006b\u0065\u0067\u0061\u006d\u0065\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1589897255517L,8589935092L,243,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_4_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

    private AnimationTimer gameTimer;

    public double originalUpdateInterval;
    double updateInterval = originalUpdateInterval;

    char dir = 'u';

    private int snakeLength;        // A j\u00e1t\u00e9k v\u00e9g\u00e9n ide t\u00e1roljuk el, hogy a hal\u00e1lkor milyen hossz\u00fa volt a k\u00edgy\u00f3

    private long startTimestamp;
    private long endTimestamp;

    public Boolean paused = false;

    Stage stage;
    Scene scene;

    Snake snake = new Snake();

    int rectSize = 13;

    int sizeX = snake.getSizeX();
    int sizeY = snake.getSizeY();

    @FXML
    private AnchorPane gameArea;

    Rectangle rectangles[][] = new Rectangle[sizeX][sizeY];

    @FXML
    Text pointsText;

    @FXML
    Text pausedText;

    @Override
    public void initialize(URL location, ResourceBundle resources){try{__CLR4_4_100kadzrxyh.R.inc(0);
        __CLR4_4_100kadzrxyh.R.inc(1);startTimestamp = System.currentTimeMillis();
        __CLR4_4_100kadzrxyh.R.inc(2);snake.body.place(17,17);
        __CLR4_4_100kadzrxyh.R.inc(3);snake.body.setSnakeLength(10);
        __CLR4_4_100kadzrxyh.R.inc(4);initRectArray();
        __CLR4_4_100kadzrxyh.R.inc(5);initGameLoop();
    }finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}

    public void pauseGame(){try{__CLR4_4_100kadzrxyh.R.inc(6);
        __CLR4_4_100kadzrxyh.R.inc(7);paused = !paused;
        __CLR4_4_100kadzrxyh.R.inc(8);if((((paused)&&(__CLR4_4_100kadzrxyh.R.iget(9)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(10)==0&false))) {{
            __CLR4_4_100kadzrxyh.R.inc(11);gameTimer.stop();
            __CLR4_4_100kadzrxyh.R.inc(12);pausedText.setVisible(true);
        } }else {{
            __CLR4_4_100kadzrxyh.R.inc(13);gameTimer.start();
            __CLR4_4_100kadzrxyh.R.inc(14);pausedText.setVisible(false);
        }
    }}finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}

    public void initListeners(Stage stage, Scene scene, String difficulty){try{__CLR4_4_100kadzrxyh.R.inc(15);
        __CLR4_4_100kadzrxyh.R.inc(16);this.stage = stage;
        __CLR4_4_100kadzrxyh.R.inc(17);this.scene = scene;
        __CLR4_4_100kadzrxyh.R.inc(18);if((((difficulty.equals("easy"))&&(__CLR4_4_100kadzrxyh.R.iget(19)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(20)==0&false))) {{
            __CLR4_4_100kadzrxyh.R.inc(21);this.originalUpdateInterval = 300;
        } }else {__CLR4_4_100kadzrxyh.R.inc(22);if((((difficulty.equals("medium"))&&(__CLR4_4_100kadzrxyh.R.iget(23)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(24)==0&false))) {{
            __CLR4_4_100kadzrxyh.R.inc(25);this.originalUpdateInterval = 200;
        } }else {__CLR4_4_100kadzrxyh.R.inc(26);if((((difficulty.equals("hard"))&&(__CLR4_4_100kadzrxyh.R.iget(27)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(28)==0&false))) {{
            __CLR4_4_100kadzrxyh.R.inc(29);this.originalUpdateInterval = 100;
        } }else {{
            __CLR4_4_100kadzrxyh.R.inc(30);this.originalUpdateInterval = 200;
        }
        }}}__CLR4_4_100kadzrxyh.R.inc(31);this.updateInterval = originalUpdateInterval;

        __CLR4_4_100kadzrxyh.R.inc(32);this.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {try{__CLR4_4_100kadzrxyh.R.inc(33);
                __CLR4_4_100kadzrxyh.R.inc(34);if((((snake.getDied())&&(__CLR4_4_100kadzrxyh.R.iget(35)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(36)==0&false))) {{
                    __CLR4_4_100kadzrxyh.R.inc(37);return;
                }
                }__CLR4_4_100kadzrxyh.R.inc(38);if((((event.getCode() == KeyCode.UP)&&(__CLR4_4_100kadzrxyh.R.iget(39)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(40)==0&false))) {{
                    __CLR4_4_100kadzrxyh.R.inc(41);dir = 'u';
                } }else {__CLR4_4_100kadzrxyh.R.inc(42);if((((event.getCode() == KeyCode.DOWN)&&(__CLR4_4_100kadzrxyh.R.iget(43)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(44)==0&false))) {{
                    __CLR4_4_100kadzrxyh.R.inc(45);dir = 'd';
                } }else {__CLR4_4_100kadzrxyh.R.inc(46);if((((event.getCode() == KeyCode.LEFT)&&(__CLR4_4_100kadzrxyh.R.iget(47)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(48)==0&false))) {{
                    __CLR4_4_100kadzrxyh.R.inc(49);dir = 'l';
                } }else {__CLR4_4_100kadzrxyh.R.inc(50);if((((event.getCode() == KeyCode.RIGHT)&&(__CLR4_4_100kadzrxyh.R.iget(51)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(52)==0&false))) {{
                    __CLR4_4_100kadzrxyh.R.inc(53);dir = 'r';
                } }else {__CLR4_4_100kadzrxyh.R.inc(54);if((((event.getCode() == KeyCode.ESCAPE)&&(__CLR4_4_100kadzrxyh.R.iget(55)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(56)==0&false))) {{
                    __CLR4_4_100kadzrxyh.R.inc(57);pauseGame();
                }
            }}}}}}finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}
        });
        __CLR4_4_100kadzrxyh.R.inc(58);log.info("Keyboard listener initialized");

        __CLR4_4_100kadzrxyh.R.inc(59);stage.setWidth(510);
        __CLR4_4_100kadzrxyh.R.inc(60);stage.setHeight(580);
    }finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}

    public void initRectArray(){try{__CLR4_4_100kadzrxyh.R.inc(61);
        __CLR4_4_100kadzrxyh.R.inc(62);for (int i = 0; (((i < snake.getSizeX())&&(__CLR4_4_100kadzrxyh.R.iget(63)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(64)==0&false)); i++) {{
            __CLR4_4_100kadzrxyh.R.inc(65);for (int j = 0; (((j < snake.getSizeY())&&(__CLR4_4_100kadzrxyh.R.iget(66)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(67)==0&false)); j++) {{
                __CLR4_4_100kadzrxyh.R.inc(68);Rectangle r = new Rectangle();
                __CLR4_4_100kadzrxyh.R.inc(69);r.setX(i*rectSize);
                __CLR4_4_100kadzrxyh.R.inc(70);r.setY(j*rectSize);
                __CLR4_4_100kadzrxyh.R.inc(71);r.setWidth(rectSize);
                __CLR4_4_100kadzrxyh.R.inc(72);r.setHeight(rectSize);
                __CLR4_4_100kadzrxyh.R.inc(73);r.setFill(Color.WHITE);
                __CLR4_4_100kadzrxyh.R.inc(74);r.setStroke(Color.DIMGREY);
                __CLR4_4_100kadzrxyh.R.inc(75);r.setStrokeWidth(1);

                __CLR4_4_100kadzrxyh.R.inc(76);gameArea.getChildren().add(r);
            }
        }}
        }__CLR4_4_100kadzrxyh.R.inc(77);log.info("Rectangle array initialized");
    }finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}

    public Rectangle getRect(int posX, int posY){try{__CLR4_4_100kadzrxyh.R.inc(78);
        __CLR4_4_100kadzrxyh.R.inc(79);return (Rectangle)gameArea.getChildren().get(posX*sizeX+posY);
    }finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}


    public void drawAllPickups(){try{__CLR4_4_100kadzrxyh.R.inc(80);
        __CLR4_4_100kadzrxyh.R.inc(81);for(Pickup p : snake.pickups.getAll()) {{
            __CLR4_4_100kadzrxyh.R.inc(82);if((((snake.pickupsDisabled.contains(p.getType()))&&(__CLR4_4_100kadzrxyh.R.iget(83)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(84)==0&false))) {{
                __CLR4_4_100kadzrxyh.R.inc(85);continue;
            }
            }__CLR4_4_100kadzrxyh.R.inc(86);Rectangle r = getRect(p.getPos().x, p.getPos().y);
            __CLR4_4_100kadzrxyh.R.inc(87);if((((p.getType().equals("apple"))&&(__CLR4_4_100kadzrxyh.R.iget(88)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(89)==0&false))) {{
                __CLR4_4_100kadzrxyh.R.inc(90);r.setFill(Color.RED);
            } }else {__CLR4_4_100kadzrxyh.R.inc(91);if((((p.getType().equals("speedup"))&&(__CLR4_4_100kadzrxyh.R.iget(92)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(93)==0&false))) {{
                __CLR4_4_100kadzrxyh.R.inc(94);r.setFill(Color.CYAN);
            } }else {__CLR4_4_100kadzrxyh.R.inc(95);if((((p.getType().equals("slowdown"))&&(__CLR4_4_100kadzrxyh.R.iget(96)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(97)==0&false))) {{
                __CLR4_4_100kadzrxyh.R.inc(98);r.setFill(Color.BLUE);
            } }else {__CLR4_4_100kadzrxyh.R.inc(99);if((((p.getType().equals("size1"))&&(__CLR4_4_100kadzrxyh.R.iget(100)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(101)==0&false))) {{
                __CLR4_4_100kadzrxyh.R.inc(102);r.setFill(Color.YELLOWGREEN);
            }
        }}}}}
    }}finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}
    public void drawAllPickupsOfType(String type){try{__CLR4_4_100kadzrxyh.R.inc(103);
        __CLR4_4_100kadzrxyh.R.inc(104);for(Pickup p : snake.pickups.getAll(type)) {{
            __CLR4_4_100kadzrxyh.R.inc(105);Rectangle r = getRect(p.getPos().x, p.getPos().y);
            __CLR4_4_100kadzrxyh.R.inc(106);r.setFill(Color.RED);
        }
    }}finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}

    public void drawBoard(){try{__CLR4_4_100kadzrxyh.R.inc(107);
//        int[][] board = snake.getBoard();

        __CLR4_4_100kadzrxyh.R.inc(108);for (int i = 0; (((i < sizeX)&&(__CLR4_4_100kadzrxyh.R.iget(109)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(110)==0&false)); i++) {{
            __CLR4_4_100kadzrxyh.R.inc(111);for (int j = 0; (((j < sizeY)&&(__CLR4_4_100kadzrxyh.R.iget(112)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(113)==0&false)); j++) {{
                __CLR4_4_100kadzrxyh.R.inc(114);Rectangle r = getRect(i,j);
                __CLR4_4_100kadzrxyh.R.inc(115);r.setFill(Color.WHITE);
            }
        }}

        }__CLR4_4_100kadzrxyh.R.inc(116);drawAllPickups();

        __CLR4_4_100kadzrxyh.R.inc(117);for (int i = 0; (((i < snake.body.size())&&(__CLR4_4_100kadzrxyh.R.iget(118)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(119)==0&false)); i++) {{
            __CLR4_4_100kadzrxyh.R.inc(120);SnakeBodyPart part = snake.body.get(i);
            __CLR4_4_100kadzrxyh.R.inc(121);Rectangle r = getRect(part.getPos().x, part.getPos().y);
            __CLR4_4_100kadzrxyh.R.inc(122);if((((i%3==0)&&(__CLR4_4_100kadzrxyh.R.iget(123)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(124)==0&false))) {{
                __CLR4_4_100kadzrxyh.R.inc(125);r.setFill(Color.BLACK);
            } }else {__CLR4_4_100kadzrxyh.R.inc(126);if((((i%3==1 || i%3==2)&&(__CLR4_4_100kadzrxyh.R.iget(127)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(128)==0&false))) {{
                __CLR4_4_100kadzrxyh.R.inc(129);r.setFill(Color.DARKGREEN);
            }
        }}}

    }}finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}

    public void pickupEffect(Pickup p){try{__CLR4_4_100kadzrxyh.R.inc(130);
        __CLR4_4_100kadzrxyh.R.inc(131);if((((p.getType().equals("apple"))&&(__CLR4_4_100kadzrxyh.R.iget(132)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(133)==0&false))) {{
            __CLR4_4_100kadzrxyh.R.inc(134);snake.body.extend();
        } }else {__CLR4_4_100kadzrxyh.R.inc(135);if((((p.getType().equals("speedup"))&&(__CLR4_4_100kadzrxyh.R.iget(136)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(137)==0&false))) {{
            __CLR4_4_100kadzrxyh.R.inc(138);snake.pickupsDisabled.add("slowdown");
            __CLR4_4_100kadzrxyh.R.inc(139);snake.pickupsDisabled.add("speedup");
            __CLR4_4_100kadzrxyh.R.inc(140);updateInterval = originalUpdateInterval * 0.5f;

            __CLR4_4_100kadzrxyh.R.inc(141);PauseTransition delay = new PauseTransition(Duration.seconds(p.getEffectDuration()));
            __CLR4_4_100kadzrxyh.R.inc(142);delay.setOnFinished(event -> {
                __CLR4_4_100kadzrxyh.R.inc(143);updateInterval = originalUpdateInterval;
                __CLR4_4_100kadzrxyh.R.inc(144);snake.pickupsDisabled.remove("slowdown");
                __CLR4_4_100kadzrxyh.R.inc(145);snake.pickupsDisabled.remove("speedup");
            });
            __CLR4_4_100kadzrxyh.R.inc(146);delay.play();
        } }else {__CLR4_4_100kadzrxyh.R.inc(147);if((((p.getType().equals("slowdown"))&&(__CLR4_4_100kadzrxyh.R.iget(148)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(149)==0&false))) {{
            __CLR4_4_100kadzrxyh.R.inc(150);snake.pickupsDisabled.add("slowdown");
            __CLR4_4_100kadzrxyh.R.inc(151);snake.pickupsDisabled.add("speedup");
            __CLR4_4_100kadzrxyh.R.inc(152);updateInterval = originalUpdateInterval * 1.5f;

            __CLR4_4_100kadzrxyh.R.inc(153);PauseTransition delay = new PauseTransition(Duration.seconds(p.getEffectDuration()));
            __CLR4_4_100kadzrxyh.R.inc(154);delay.setOnFinished(event -> {
                __CLR4_4_100kadzrxyh.R.inc(155);updateInterval = originalUpdateInterval;
                __CLR4_4_100kadzrxyh.R.inc(156);snake.pickupsDisabled.remove("slowdown");
                __CLR4_4_100kadzrxyh.R.inc(157);snake.pickupsDisabled.remove("speedup");
            });
            __CLR4_4_100kadzrxyh.R.inc(158);delay.play();
        } }else {__CLR4_4_100kadzrxyh.R.inc(159);if((((p.getType().equals("size1"))&&(__CLR4_4_100kadzrxyh.R.iget(160)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(161)==0&false))) {{
            __CLR4_4_100kadzrxyh.R.inc(162);snake.pickupsDisabled.add("apple");
            __CLR4_4_100kadzrxyh.R.inc(163);snake.pickupsDisabled.add("size1");
            __CLR4_4_100kadzrxyh.R.inc(164);int originalSize = snake.body.size();
            __CLR4_4_100kadzrxyh.R.inc(165);snake.body.setSnakeLength(1);

            __CLR4_4_100kadzrxyh.R.inc(166);PauseTransition delay = new PauseTransition(Duration.seconds(p.getEffectDuration()));
            __CLR4_4_100kadzrxyh.R.inc(167);delay.setOnFinished(event -> {
                __CLR4_4_100kadzrxyh.R.inc(168);snake.body.setSnakeLength(originalSize);
                __CLR4_4_100kadzrxyh.R.inc(169);snake.pickupsDisabled.remove("apple");
                __CLR4_4_100kadzrxyh.R.inc(170);snake.pickupsDisabled.remove("size1");
            });
            __CLR4_4_100kadzrxyh.R.inc(171);delay.play();
        }
    }}}}}finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}

    public void moveSnake(){try{__CLR4_4_100kadzrxyh.R.inc(172);
        __CLR4_4_100kadzrxyh.R.inc(173);snake.move();
        __CLR4_4_100kadzrxyh.R.inc(174);if((((snake.getDied())&&(__CLR4_4_100kadzrxyh.R.iget(175)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(176)==0&false))) {{
            __CLR4_4_100kadzrxyh.R.inc(177);try {
                __CLR4_4_100kadzrxyh.R.inc(178);die();
            } catch (IOException e) {
                __CLR4_4_100kadzrxyh.R.inc(179);e.printStackTrace();
            }
        }
        }__CLR4_4_100kadzrxyh.R.inc(180);Pickup lastEaten = snake.popLastEaten();
        __CLR4_4_100kadzrxyh.R.inc(181);if((((!lastEaten.getType().equals("empty"))&&(__CLR4_4_100kadzrxyh.R.iget(182)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(183)==0&false))) {{
            __CLR4_4_100kadzrxyh.R.inc(184);pickupEffect(lastEaten);
        }
    }}finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}

    public void switchToGameOverWindow(){try{__CLR4_4_100kadzrxyh.R.inc(185);
        __CLR4_4_100kadzrxyh.R.inc(186);FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/gameover.fxml"));
        __CLR4_4_100kadzrxyh.R.inc(187);try {
            __CLR4_4_100kadzrxyh.R.inc(188);Parent root = (Parent)loader.load();
            __CLR4_4_100kadzrxyh.R.inc(189);GameOverController controller = (GameOverController)loader.getController();
            __CLR4_4_100kadzrxyh.R.inc(190);Scene scene = new Scene(root);

            __CLR4_4_100kadzrxyh.R.inc(191);int timeSurvivedSeconds = Math.round((float)(endTimestamp-startTimestamp)/1000);
            __CLR4_4_100kadzrxyh.R.inc(192);log.info("Time survived in seconds: {}", timeSurvivedSeconds);

            __CLR4_4_100kadzrxyh.R.inc(193);GameResult result = new GameResult();
            __CLR4_4_100kadzrxyh.R.inc(194);result.setNumOfPickups(snake.pickups.getPickupsEaten());
            __CLR4_4_100kadzrxyh.R.inc(195);result.setScore(snake.getPoints());
            __CLR4_4_100kadzrxyh.R.inc(196);result.setSnakeLength(snakeLength);
            __CLR4_4_100kadzrxyh.R.inc(197);result.setTimeSurvived(timeSurvivedSeconds);

            __CLR4_4_100kadzrxyh.R.inc(198);controller.init(result);      // eredm\u00e9ny \u00e1tad\u00e1sa a GameOver controllernek

            __CLR4_4_100kadzrxyh.R.inc(199);stage.setTitle("Game Over!");
            __CLR4_4_100kadzrxyh.R.inc(200);stage.setResizable(false);

            __CLR4_4_100kadzrxyh.R.inc(201);stage.setScene(scene);
            __CLR4_4_100kadzrxyh.R.inc(202);stage.show();
        } catch (IOException e) {
            __CLR4_4_100kadzrxyh.R.inc(203);e.printStackTrace();
        }
    }finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}

    public void die() throws IOException {try{__CLR4_4_100kadzrxyh.R.inc(204);
        __CLR4_4_100kadzrxyh.R.inc(205);endTimestamp = System.currentTimeMillis();
        __CLR4_4_100kadzrxyh.R.inc(206);snakeLength = snake.body.size();
        __CLR4_4_100kadzrxyh.R.inc(207);gameTimer.stop();

        __CLR4_4_100kadzrxyh.R.inc(208);float dieAnimationInterval = 2000/(float)snake.body.size();

        __CLR4_4_100kadzrxyh.R.inc(209);AnimationTimer dieTimer = new AnimationTimer(){
            private long lastUpdate = 0;
            @Override
            public void handle(long now){try{__CLR4_4_100kadzrxyh.R.inc(210);
                __CLR4_4_100kadzrxyh.R.inc(211);if((((now - lastUpdate >= dieAnimationInterval*1000*1000)&&(__CLR4_4_100kadzrxyh.R.iget(212)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(213)==0&false))) {{
                    __CLR4_4_100kadzrxyh.R.inc(214);if((((snake.body.size() > 1)&&(__CLR4_4_100kadzrxyh.R.iget(215)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(216)==0&false))) {{
                        __CLR4_4_100kadzrxyh.R.inc(217);snake.body.shrink();
                        __CLR4_4_100kadzrxyh.R.inc(218);drawBoard();
                    } }else {{
                        __CLR4_4_100kadzrxyh.R.inc(219);this.stop();
                        __CLR4_4_100kadzrxyh.R.inc(220);switchToGameOverWindow();
                    }
                    }__CLR4_4_100kadzrxyh.R.inc(221);lastUpdate = now;
                }
            }}finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}
        };
        __CLR4_4_100kadzrxyh.R.inc(222);dieTimer.start();
    }finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}

    private void initGameLoop(){try{__CLR4_4_100kadzrxyh.R.inc(223);
        __CLR4_4_100kadzrxyh.R.inc(224);gameTimer = new AnimationTimer(){
            private long lastUpdate = 0;
            @Override
            public void handle(long now){try{__CLR4_4_100kadzrxyh.R.inc(225);
                __CLR4_4_100kadzrxyh.R.inc(226);if((((now - lastUpdate >= updateInterval*1000*1000)&&(__CLR4_4_100kadzrxyh.R.iget(227)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(228)==0&false))) {{
                    __CLR4_4_100kadzrxyh.R.inc(229);if((((dir != snake.getDirection())&&(__CLR4_4_100kadzrxyh.R.iget(230)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(231)==0&false))) {{
                        __CLR4_4_100kadzrxyh.R.inc(232);snake.setDirection(dir);
                    }
                    }__CLR4_4_100kadzrxyh.R.inc(233);moveSnake();
                    __CLR4_4_100kadzrxyh.R.inc(234);drawBoard();

                    __CLR4_4_100kadzrxyh.R.inc(235);lastUpdate = now;

                    __CLR4_4_100kadzrxyh.R.inc(236);pointsText.setText(Integer.toString(snake.getPoints()));
                }
                }__CLR4_4_100kadzrxyh.R.inc(237);if((((snake.pickups.canPlacePickup())&&(__CLR4_4_100kadzrxyh.R.iget(238)!=0|true))||(__CLR4_4_100kadzrxyh.R.iget(239)==0&false))) {{
                    __CLR4_4_100kadzrxyh.R.inc(240);snake.placeRandomPickup();
                }
            }}finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}
        };
        __CLR4_4_100kadzrxyh.R.inc(241);gameTimer.start();
        __CLR4_4_100kadzrxyh.R.inc(242);log.info("Game loop initialized");
    }finally{__CLR4_4_100kadzrxyh.R.flushNeeded();}}
}
