package snake;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {

    Snake snake;

    @BeforeEach
    void initialize(){
        snake = new Snake();
    }

    @AfterEach
    void destroy(){
        snake = null;
    }

    @Test
    void testPlace(){
        snake.body.place(17,18);
        assertEquals(17, snake.body.get(0).getPos().x);
        assertEquals(18, snake.body.get(0).getPos().y);
    }

    @Test
    void testPlaceAgain(){
        snake.body.place(17,18);
        snake.body.place(18,19);
        assertEquals(17, snake.body.get(0).getPos().x);
        assertEquals(18, snake.body.get(0).getPos().y);
    }

    @Test
    void testInvalidPlace(){
        assertThrows(IllegalArgumentException.class, () -> snake.place(-1,-1));
    }

    @Test
    void testMove(){
        snake.place(17,17);
        snake.move();
        snake.move();
        snake.move();
        assertEquals(17, snake.body.get(0).getPos().x);
        assertEquals(14, snake.body.get(0).getPos().y);

        snake.setDirection('r');
        snake.move();
        snake.move();
        snake.setDirection('d');
        snake.move();
        snake.move();
        assertEquals(19, snake.body.get(0).getPos().x);
        assertEquals(16, snake.body.get(0).getPos().y);
    }

    @Test
    void testDirectionUpDown(){
        snake.place(17,17);
        snake.move();
        snake.setDirection('d');
        assertEquals('u', snake.getDirection());
    }

    @Test
    void testDirectionDownUp(){
        snake.place(17,17);
        snake.move();
        snake.setDirection('r');
        snake.move();
        snake.setDirection('d');
        snake.move();
        snake.setDirection('u');
        assertEquals('d', snake.getDirection());
    }

    @Test
    void testDirectionLeftRight(){
        snake.place(17,17);
        snake.move();
        snake.setDirection('l');
        snake.move();
        snake.setDirection('r');
        assertEquals('l', snake.getDirection());
    }

    @Test
    void testDirectionRightLeft(){
        snake.place(17,17);
        snake.move();
        snake.setDirection('r');
        snake.move();
        snake.setDirection('l');
        assertEquals('r', snake.getDirection());
    }

    @Test
    void testSnakeLength(){
        snake.place(17,17);
        snake.body.extend();
        snake.body.extend();
        snake.body.extend();
        assertEquals(4, snake.body.size());
    }

    @Test
    void testGoToOtherSide(){
        snake.place(0,17);
        snake.setDirection('l');
        snake.move();
        assertEquals(snake.getSizeX()-1, snake.body.get(0).getPos().x);
        assertEquals(17, snake.body.get(0).getPos().y);
    }

    @Test
    void testSnakeDie(){
        snake.place(17,17);
        snake.body.extend();
        snake.body.extend();
        snake.body.extend();
        snake.body.extend();
        snake.body.extend();
        snake.body.extend();
        snake.body.extend();
        snake.move();
        snake.move();
        snake.move();
        snake.move();
        snake.move();
        snake.move();
        snake.move();
        snake.move();
        snake.setDirection('l');
        snake.move();
        snake.setDirection('d');
        snake.move();
        snake.setDirection('r');

        assertEquals(false, snake.getDied());
        snake.move();
        assertEquals(true, snake.getDied());
    }
}
