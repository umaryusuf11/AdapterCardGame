package Game;

import Console.ConsoleInput;
import Console.InputTestAdapter;
import Console.OutputTestAdapter;
import Game.CardGame;
import Structure.Hand;
import Structure.LoadConfig;
import Structure.LoadTestAdapter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

class CardGameTest {
    CardGame cardGame = new CardGame();

    @Test
    void getDeck() {
        assertEquals(52, cardGame.getDeck().size());
    }

    @Test
    void cardGameOverride(){
        CardGame overrideCardGame = new CardGame("H3,H4,H5,D6");
        assertEquals(4, overrideCardGame.getDeck().size());
    }

    @Test
    void dealCards() {
        CardGame cardGame = new CardGame("D3,D2,S5,S6");
        Hand hand = new Hand();
        hand = cardGame.dealHand(hand, 3);
        assertEquals("S6, S5, D2", hand.toString());
    }

    @Test
    void outputOne(){
        cardGame.output("Test One");
        assertEquals("Test One", cardGame.userOutput.getStoreOutput().get(0));
    }

    @Test
    void outputTwo(){
        cardGame.output("Test One");
        cardGame.output("Test Two");
        assertEquals("Test Two", cardGame.userOutput.getStoreOutput().get(1));
    }

    @Test
    void outputTwoCount(){
        cardGame.output("Test One");
        cardGame.output("Test Two");
        assertEquals(2, cardGame.userOutput.getStoreOutput().size());
    }


    @Test
    void getNumberOfPlayers(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("3");
        cardGame.userInput.setUserInput(mockScanner);
        assertEquals(3, cardGame.getNumberOfComputerPlayers());
    }

    @Test
    void getInteger(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("3");
        cardGame.userInput.setUserInput(mockScanner);
        assertEquals(3, cardGame.getInteger());
    }

    @Test
    void getIntegerFirstString(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("one");
        when(mockScanner.nextLine()).thenReturn("25");
        cardGame.userInput.setUserInput(mockScanner);
        assertEquals(25, cardGame.getInteger());
    }

    @Test
    void getString(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("yes");
        cardGame.userInput.setUserInput(mockScanner);
        assertEquals("yes", cardGame.getString());
    }

    @Test
    void getComputerPlayersNames(){
        List<String> mockNames = new ArrayList<String>();
        mockNames.add("Don Tester");
        mockNames.add("Susan Tester");
        mockNames.add("Agnes Tester");
        LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(mockNames);
        cardGame.setLoadConfig(mockLoadConfig);
        assertEquals(mockNames, cardGame.getComputerPlayersNames());
    }

    @Test
    void getComputerPlayersNamesAdapter(){
        List<String> mockNames = new ArrayList<String>();
        mockNames.add("Don Tester");
        mockNames.add("Susan Tester");
        mockNames.add("Agnes Tester");
        LoadTestAdapter mockLoadTestAdapter = mock(LoadTestAdapter.class);
        when(mockLoadTestAdapter.getConfig()).thenReturn(mockNames);
        cardGame.setLoadConfig(mockLoadTestAdapter);
        assertEquals(mockNames, cardGame.getComputerPlayersNames());
    }

    @Test
    void createComputerPlayers(){
        List<String> mockNames = new ArrayList<String>();
        mockNames.add("Don A Dealer");
        mockNames.add("Susan A Tester");
        mockNames.add("Agnes Is Great");
        LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(mockNames);
        cardGame.setLoadConfig(mockLoadConfig);
        cardGame.createComputerPlayers(3);
        assertEquals("Agnes Is Great",cardGame.players.get(2).getName());
    }

    @Test
    void createComputerPlayersAdapter(){
        List<String> mockNames = new ArrayList<String>();
        mockNames.add("Don A Dealer");
        mockNames.add("Susan A Tester");
        mockNames.add("Agnes Is Great");
        LoadTestAdapter mockLoadTestAdapter = mock(LoadTestAdapter.class);
        when(mockLoadTestAdapter.getConfig()).thenReturn(mockNames);
        cardGame.setLoadConfig(mockLoadTestAdapter);
        cardGame.createComputerPlayers(3);
        assertEquals("Agnes Is Great", cardGame.players.get(2).getName());
    }

    @Test
    void createComputerPlayersSize(){
        List<String> mockNames = new ArrayList<String>();
        mockNames.add("Don A Dealer");
        mockNames.add("Susan A Tester");
        mockNames.add("Agnes Is Great");
        LoadConfig mockLoadConfig = mock(LoadConfig.class);
        when(mockLoadConfig.getConfig()).thenReturn(mockNames);
        cardGame.setLoadConfig(mockLoadConfig);
        cardGame.createComputerPlayers(3);
        assertEquals(3,cardGame.players.size());
    }

    @Test
    void createComputerPlayersSizeAdapter(){
        List<String> mockNames = new ArrayList<String>();
        mockNames.add("Don A Dealer");
        mockNames.add("Susan A Tester");
        mockNames.add("Agnes Is Great");
        LoadTestAdapter mockLoadTestAdapter = mock(LoadTestAdapter.class);
        when(mockLoadTestAdapter.getConfig()).thenReturn(mockNames);
        cardGame.setLoadConfig(mockLoadTestAdapter);
        cardGame.createComputerPlayers(3);
        assertEquals(3,cardGame.players.size());
    }

    @Test
    void createHumanPlayer(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Derek");
        cardGame.userInput.setUserInput(mockScanner);
        cardGame.createHumanPlayer();
        assertEquals("Derek", cardGame.players.get(0).getName());
    }

    @Test
    void createHumanPlayerAdapter(){
        OutputTestAdapter outputTestAdapter = new OutputTestAdapter();
        InputTestAdapter inputTestAdapter = new InputTestAdapter(outputTestAdapter);
        cardGame.setUserInput(inputTestAdapter);
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Derek");
        cardGame.userInput.setUserInput(mockScanner);
        cardGame.createHumanPlayer();
        assertEquals("Derek", cardGame.players.get(0).getName());
    }

    @Test
    void initiatePlayers(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Derek");
        when(mockScanner.nextLine()).thenReturn("2");
        cardGame.userInput.setUserInput(mockScanner);
        cardGame.initiatePlayers();
        assertEquals(3, cardGame.players.size());
    }

    @Test
    void initiatePlayersAdapter(){
        OutputTestAdapter outputTestAdapter = new OutputTestAdapter();
        InputTestAdapter inputTestAdapter = new InputTestAdapter(outputTestAdapter);
        cardGame.setUserInput(inputTestAdapter);
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Derek");
        when(mockScanner.nextLine()).thenReturn("2");
        cardGame.userInput.setUserInput(mockScanner);
        cardGame.initiatePlayers();
        assertEquals(3, cardGame.players.size());
    }

    @Test
    void initiate(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Derek");
        when(mockScanner.nextLine()).thenReturn("2");
        cardGame.userInput.setUserInput(mockScanner);
        cardGame.initiate();
        assertEquals(2, cardGame.players.get(0).getHand().size());
    }

    @Test
    void initiateAdapter(){
        OutputTestAdapter outputTestAdapter = new OutputTestAdapter();
        InputTestAdapter inputTestAdapter = new InputTestAdapter(outputTestAdapter);
        cardGame.setUserInput(inputTestAdapter);
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Derek");
        when(mockScanner.nextLine()).thenReturn("2");
        cardGame.userInput.setUserInput(mockScanner);
        cardGame.initiate();
        assertEquals(2, cardGame.players.get(0).getHand().size());
    }

    @Test
    void play(){
        ConsoleInput mockInput = mock(ConsoleInput.class);
        when(mockInput.getString()).thenReturn("Derek").thenReturn("T");
        when(mockInput.getInteger()).thenReturn(2);
        cardGame.setUserInput(mockInput);
        cardGame.setFinishGame(true);
        cardGame.play();
        assertTrue(cardGame.finshGame);
    }

    @Test
    void playAdapter(){
        List<String> mockNames = new ArrayList<String>();
        mockNames.add("Don A Dealer");
        mockNames.add("Susan A Tester");
        mockNames.add("Agnes Is Great");
        LoadTestAdapter mockLoadTestAdapter = mock(LoadTestAdapter.class);
        when(mockLoadTestAdapter.getConfig()).thenReturn(mockNames);
        cardGame.setLoadConfig(mockLoadTestAdapter);

        OutputTestAdapter outputTestAdapter = new OutputTestAdapter();
        InputTestAdapter inputTestAdapter = new InputTestAdapter(outputTestAdapter);
        cardGame.setUserInput(inputTestAdapter);
        InputTestAdapter mockInput = mock(InputTestAdapter.class);
        when(mockInput.getString()).thenReturn("Derek").thenReturn("T");
        when(mockInput.getInteger()).thenReturn(2);
        cardGame.setUserInput(mockInput);

        cardGame.setFinishGame(true);
        cardGame.play();
        assertTrue(cardGame.finshGame);
    }

}