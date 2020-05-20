/* $$ This file has been instrumented by Clover 4.4.1#2019101123313948 $$ */package snake;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

@java.lang.SuppressWarnings({"fallthrough"}) @Slf4j
public class Snake {public static class __CLR4_4_1azazkadzry89{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_4_1();if(2019101123313948L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.4.1#2019101123313948,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u006c\u0061\u006a\u0062\u0079\u002f\u0044\u0045\u002d\u0049\u004b\u0020\u0032\u0030\u0031\u0039\u002d\u0032\u0030\u002d\u0032\u002f\u0050\u0072\u006f\u0067\u0074\u0065\u0063\u0068\u002f\u0048\u0061\u007a\u0069\u005f\u0070\u0072\u006f\u006a\u0065\u006b\u0074\u002f\u0073\u006e\u0061\u006b\u0065\u0067\u0061\u006d\u0065\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1589897255517L,8589935092L,542,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_4_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

    @Getter
    private int sizeX = 37;
    @Getter
    private int sizeY = 37;

    @Getter
    private int points = 0;

    @Getter
    private Boolean died = false;

    public ArrayList<String> pickupsDisabled = new ArrayList<String>();

    public void addPoints(int p){try{__CLR4_4_1azazkadzry89.R.inc(395);
        __CLR4_4_1azazkadzry89.R.inc(396);points += p;
    }finally{__CLR4_4_1azazkadzry89.R.flushNeeded();}}

//    @Getter
//    private int[][] board = new int[sizeX][sizeY];

    public Pickups pickups = new Pickups();

    private Pickup lastEatenPickup = new Pickup(new Point(0,0),"empty");
    public Pickup popLastEaten(){try{__CLR4_4_1azazkadzry89.R.inc(397);
        __CLR4_4_1azazkadzry89.R.inc(398);Pickup p = new Pickup(lastEatenPickup);
        __CLR4_4_1azazkadzry89.R.inc(399);lastEatenPickup = new Pickup(new Point(0,0), "empty");
        __CLR4_4_1azazkadzry89.R.inc(400);return p;
    }finally{__CLR4_4_1azazkadzry89.R.flushNeeded();}}

    public SnakeBody body = new SnakeBody();

//    private Boolean snakePlaced = false;

    @Getter
    private char direction = 'u';

    public void setDirection(char dirNew){try{__CLR4_4_1azazkadzry89.R.inc(401);
        __CLR4_4_1azazkadzry89.R.inc(402);if((((!(dirNew == 'u' || dirNew == 'd' || dirNew == 'l' || dirNew == 'r'))&&(__CLR4_4_1azazkadzry89.R.iget(403)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(404)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(405);throw new IllegalArgumentException();
        }
        }__CLR4_4_1azazkadzry89.R.inc(406);char dir = getDirection();
        __CLR4_4_1azazkadzry89.R.inc(407);if((((dirNew == dir)&&(__CLR4_4_1azazkadzry89.R.iget(408)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(409)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(410);return;
        }
        }__CLR4_4_1azazkadzry89.R.inc(411);if(
                (((dirNew == 'd' && dir == 'u'
                || dirNew == 'u' && dir == 'd'
                || dirNew == 'l' && dir == 'r'
                || dirNew == 'r' && dir == 'l'
        )&&(__CLR4_4_1azazkadzry89.R.iget(412)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(413)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(414);log.info("Can't change direction to opposite!");
            __CLR4_4_1azazkadzry89.R.inc(415);return;
        }

        }__CLR4_4_1azazkadzry89.R.inc(416);this.direction = dirNew;
        __CLR4_4_1azazkadzry89.R.inc(417);String d = "";
        boolean __CLB4_4_1_bool0=false;__CLR4_4_1azazkadzry89.R.inc(418);switch(dirNew){
            case 'u':if (!__CLB4_4_1_bool0) {__CLR4_4_1azazkadzry89.R.inc(419);__CLB4_4_1_bool0=true;} __CLR4_4_1azazkadzry89.R.inc(420);d = "UP"; __CLR4_4_1azazkadzry89.R.inc(421);break;
            case 'd':if (!__CLB4_4_1_bool0) {__CLR4_4_1azazkadzry89.R.inc(422);__CLB4_4_1_bool0=true;} __CLR4_4_1azazkadzry89.R.inc(423);d = "DOWN"; __CLR4_4_1azazkadzry89.R.inc(424);break;
            case 'l':if (!__CLB4_4_1_bool0) {__CLR4_4_1azazkadzry89.R.inc(425);__CLB4_4_1_bool0=true;} __CLR4_4_1azazkadzry89.R.inc(426);d = "LEFT"; __CLR4_4_1azazkadzry89.R.inc(427);break;
            case 'r':if (!__CLB4_4_1_bool0) {__CLR4_4_1azazkadzry89.R.inc(428);__CLB4_4_1_bool0=true;} __CLR4_4_1azazkadzry89.R.inc(429);d = "RIGHT"; __CLR4_4_1azazkadzry89.R.inc(430);break;
        }
        __CLR4_4_1azazkadzry89.R.inc(431);log.info("direction changed to {}", d);
    }finally{__CLR4_4_1azazkadzry89.R.flushNeeded();}}

    public Snake(int posX, int posY){try{__CLR4_4_1azazkadzry89.R.inc(432);
//        initTable();
        __CLR4_4_1azazkadzry89.R.inc(433);place(posX, posY);
    }finally{__CLR4_4_1azazkadzry89.R.flushNeeded();}}
    public Snake(){try{__CLR4_4_1azazkadzry89.R.inc(434);
//        initTable();
    }finally{__CLR4_4_1azazkadzry89.R.flushNeeded();}}

//    public void initTable(){
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                board[i][j] = 0;
//            }
//        }
//    }

    public int[][] getBoard(){try{__CLR4_4_1azazkadzry89.R.inc(435);
        __CLR4_4_1azazkadzry89.R.inc(436);int[][] board = new int[sizeX][sizeY];

        __CLR4_4_1azazkadzry89.R.inc(437);for (int i = 0; (((i < sizeX)&&(__CLR4_4_1azazkadzry89.R.iget(438)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(439)==0&false)); i++) {{
            __CLR4_4_1azazkadzry89.R.inc(440);for (int j = 0; (((j < sizeY)&&(__CLR4_4_1azazkadzry89.R.iget(441)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(442)==0&false)); j++) {{
                __CLR4_4_1azazkadzry89.R.inc(443);board[i][j] = 0;
            }
        }}

        }__CLR4_4_1azazkadzry89.R.inc(444);for (Pickup p : pickups.getAll()) {{
            __CLR4_4_1azazkadzry89.R.inc(445);int pX = p.getPos().x;
            __CLR4_4_1azazkadzry89.R.inc(446);int pY = p.getPos().y;
            __CLR4_4_1azazkadzry89.R.inc(447);board[pX][pY] = 1;
        }

        }__CLR4_4_1azazkadzry89.R.inc(448);for(SnakeBodyPart p : body.getBody()){{
            __CLR4_4_1azazkadzry89.R.inc(449);int pX = p.getPos().x;
            __CLR4_4_1azazkadzry89.R.inc(450);int pY = p.getPos().y;
            __CLR4_4_1azazkadzry89.R.inc(451);board[pX][pY] = 2;
        }

        }__CLR4_4_1azazkadzry89.R.inc(452);return board;
    }finally{__CLR4_4_1azazkadzry89.R.flushNeeded();}}

    public Vector<Point> getEmptyCellsOfBoard(){try{__CLR4_4_1azazkadzry89.R.inc(453);
        __CLR4_4_1azazkadzry89.R.inc(454);Vector<Point> cells = new Vector<Point>();

        __CLR4_4_1azazkadzry89.R.inc(455);int[][] board = getBoard();

        __CLR4_4_1azazkadzry89.R.inc(456);for (int i = 0; (((i < board.length)&&(__CLR4_4_1azazkadzry89.R.iget(457)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(458)==0&false)); i++) {{
            __CLR4_4_1azazkadzry89.R.inc(459);for (int j = 0; (((j < board[0].length)&&(__CLR4_4_1azazkadzry89.R.iget(460)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(461)==0&false)); j++) {{
                __CLR4_4_1azazkadzry89.R.inc(462);if((((board[i][j] == 0)&&(__CLR4_4_1azazkadzry89.R.iget(463)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(464)==0&false))) {{
                    __CLR4_4_1azazkadzry89.R.inc(465);cells.add(new Point(i,j));
                }
            }}
        }}

        }__CLR4_4_1azazkadzry89.R.inc(466);return cells;
    }finally{__CLR4_4_1azazkadzry89.R.flushNeeded();}}

    public void place(int posX, int posY){try{__CLR4_4_1azazkadzry89.R.inc(467);
        __CLR4_4_1azazkadzry89.R.inc(468);if((((posX >= sizeX || posY >= sizeY || posX < 0 || posY < 0)&&(__CLR4_4_1azazkadzry89.R.iget(469)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(470)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(471);throw new IllegalArgumentException();
        }
        }__CLR4_4_1azazkadzry89.R.inc(472);body.place(posX, posY);
    }finally{__CLR4_4_1azazkadzry89.R.flushNeeded();}}

    public void move(){try{__CLR4_4_1azazkadzry89.R.inc(473);
        __CLR4_4_1azazkadzry89.R.inc(474);if((((body.size() > 1)&&(__CLR4_4_1azazkadzry89.R.iget(475)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(476)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(477);for (int i = body.size()-1; (((i >= 1)&&(__CLR4_4_1azazkadzry89.R.iget(478)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(479)==0&false)); i--) {{
                __CLR4_4_1azazkadzry89.R.inc(480);body.get(i).set(body.get(i-1));
            }
        }}

        }__CLR4_4_1azazkadzry89.R.inc(481);SnakeBodyPart head = body.get(0);
        __CLR4_4_1azazkadzry89.R.inc(482);if((((direction == 'u')&&(__CLR4_4_1azazkadzry89.R.iget(483)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(484)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(485);head.set(head.getPos().x, head.getPos().y-1);
        } }else {__CLR4_4_1azazkadzry89.R.inc(486);if((((direction == 'd')&&(__CLR4_4_1azazkadzry89.R.iget(487)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(488)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(489);head.set(head.getPos().x, head.getPos().y+1);
        } }else {__CLR4_4_1azazkadzry89.R.inc(490);if((((direction == 'l')&&(__CLR4_4_1azazkadzry89.R.iget(491)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(492)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(493);head.set(head.getPos().x-1, head.getPos().y);
        } }else {__CLR4_4_1azazkadzry89.R.inc(494);if((((direction == 'r')&&(__CLR4_4_1azazkadzry89.R.iget(495)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(496)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(497);head.set(head.getPos().x+1, head.getPos().y);
        }

        // snake can go through edge of map to other side
        }}}}__CLR4_4_1azazkadzry89.R.inc(498);head.set(head.getPos().x % sizeX, head.getPos().y % sizeY);
        __CLR4_4_1azazkadzry89.R.inc(499);if((((head.getPos().x < 0)&&(__CLR4_4_1azazkadzry89.R.iget(500)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(501)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(502);head.set(sizeX-head.getPos().x-2, head.getPos().y);
        }
        }__CLR4_4_1azazkadzry89.R.inc(503);if((((head.getPos().y < 0)&&(__CLR4_4_1azazkadzry89.R.iget(504)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(505)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(506);head.set(head.getPos().x, sizeY-head.getPos().y-2);
        }
        }__CLR4_4_1azazkadzry89.R.inc(507);log.info("Snake head position: ({},{})", head.getPos().x, head.getPos().y);

//        log.info("------------- body parts ----------------------");
//        for (int i = 0; i < body.size(); i++) {
//            log.info(i+". bodypart: ({},{})", body.get(i).getPos().x, body.get(i).getPos().y);
//        }

        __CLR4_4_1azazkadzry89.R.inc(508);if((((body.isHeadCollidingWithBody())&&(__CLR4_4_1azazkadzry89.R.iget(509)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(510)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(511);log.info("Snake Collision with itself! Snake died!");
            __CLR4_4_1azazkadzry89.R.inc(512);died = true;
        }

        }__CLR4_4_1azazkadzry89.R.inc(513);int pickupIndexCollidingWithHead = getPickupIndexCollidingWithHead();
        __CLR4_4_1azazkadzry89.R.inc(514);if((((pickupIndexCollidingWithHead != -1 && !pickupsDisabled.contains(pickups.get(pickupIndexCollidingWithHead).getType()))&&(__CLR4_4_1azazkadzry89.R.iget(515)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(516)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(517);lastEatenPickup = pickups.eat(pickupIndexCollidingWithHead);
            __CLR4_4_1azazkadzry89.R.inc(518);addPoints(lastEatenPickup.getPoints());
            __CLR4_4_1azazkadzry89.R.inc(519);log.info("Snake has eaten a(n) {}", lastEatenPickup.getType());
        }
    }}finally{__CLR4_4_1azazkadzry89.R.flushNeeded();}}

    public void placeRandomPickup(){try{__CLR4_4_1azazkadzry89.R.inc(520);
        __CLR4_4_1azazkadzry89.R.inc(521);Vector<Point> emptyCells = getEmptyCellsOfBoard();
        __CLR4_4_1azazkadzry89.R.inc(522);if((((emptyCells.size() > 0)&&(__CLR4_4_1azazkadzry89.R.iget(523)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(524)==0&false))) {{
            __CLR4_4_1azazkadzry89.R.inc(525);int randomIndex = ThreadLocalRandom.current().nextInt(0, emptyCells.size());
            __CLR4_4_1azazkadzry89.R.inc(526);String nextRandomPickup = pickups.getNextRandomPlaceablePickup();
            __CLR4_4_1azazkadzry89.R.inc(527);if((((!nextRandomPickup.equals(""))&&(__CLR4_4_1azazkadzry89.R.iget(528)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(529)==0&false))) {{
                __CLR4_4_1azazkadzry89.R.inc(530);pickups.place(
                        new Pickup(
                                emptyCells.get(randomIndex),
                                nextRandomPickup,
                                pickups.getEffectTimers().get(nextRandomPickup),
                                pickups.getEffectDurations().get(nextRandomPickup),
                                pickups.getPoints().get(nextRandomPickup)
                        )
                );
            }
        }}

//        for (int i = 0; i < pickups.getAll().size(); i++) {
//            log.info("Pickup at ({},{})", pickups.get(i).getPos().x, pickups.get(i).getPos().y);
//        }
    }}finally{__CLR4_4_1azazkadzry89.R.flushNeeded();}}

    public int getPickupIndexCollidingWithHead(){try{__CLR4_4_1azazkadzry89.R.inc(531);
        __CLR4_4_1azazkadzry89.R.inc(532);int in = -1;

        __CLR4_4_1azazkadzry89.R.inc(533);Pickups ps = pickups;
        __CLR4_4_1azazkadzry89.R.inc(534);for (int i=0; (((i<ps.getAll().size())&&(__CLR4_4_1azazkadzry89.R.iget(535)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(536)==0&false)); i++) {{
            __CLR4_4_1azazkadzry89.R.inc(537);if(
//                    body.get(0).getPos().x == ps.get(i).getPos().x && body.get(0).getPos().y == ps.get(i).getPos().y
                    (((body.get(0).equals(ps.get(i))
            )&&(__CLR4_4_1azazkadzry89.R.iget(538)!=0|true))||(__CLR4_4_1azazkadzry89.R.iget(539)==0&false))) {{
                __CLR4_4_1azazkadzry89.R.inc(540);in = i;
            }
        }}

        }__CLR4_4_1azazkadzry89.R.inc(541);return in;
    }finally{__CLR4_4_1azazkadzry89.R.flushNeeded();}}

}
