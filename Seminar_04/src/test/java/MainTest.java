import Card.CreditCard;
import Card.PaymentForm;
import DataBase.DataProcessor;
import DataBase.Database;
import Hotel.BookingService;
import Hotel.HotelService;
import Message.MessageService;
import Message.NotificationService;
import Weather.WeatherReporter;
import Weather.WeatherService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;

public class MainTest {
    @Test
    public void simpleTest() {
        List<String> mockedList = mock(List.class);
        mockedList.add("One");
        mockedList.clear();
        verify(mockedList).add("One");
        verify(mockedList).clear();
    }
    @Test
    void iteratorWillReturnHelloWorld(){
        // Arrange - создаем набор данные
        Iterator iteratorMock = mock(Iterator.class); // указываем, кем mock должен представиться
//        when(iteratorMock.next()).thenReturn("Hello", "World");
        when(iteratorMock.next()).thenReturn("Hello").thenReturn("World"); // при
        // Act - что мы отлавливаем
        String result = iteratorMock.next() + " " + iteratorMock.next();
        assertEquals("Hello World", result);
    }
    @Test
    void testCharge() {
        // Создаем mock класс
        CreditCard card = mock(CreditCard.class);
        // Говорим, как на вызовы нужно реагировать,
        // то есть, спросят номер карты - должен вернуть "1234"
        when(card.getCardNumber()).thenReturn("1234");
        when(card.getCardHolder()).thenReturn("user");
        when(card.getExpiryDate()).thenReturn("31.12.2023");
        when(card.getCvv()).thenReturn("123");

        PaymentForm paymentForm = new PaymentForm(card);
        paymentForm.pay(1000);

        verify(card, times(1)).charge(1000);
        // card - какой mock объект рассматриваем
        // times - сколько раз был вызван метод
        // charge - проверяем метод
        // функция verify проверяет нашу карточку и говорит,
        // что операция произошла 1 раз, указываем какой метод был отработан
        // и что он сделал
    }

    @Test
    void testWeatherServiceGetCorrectTemperature() {
        WeatherService weatherService = mock(WeatherService.class);
        when(weatherService.getCurrentTemperature()).thenReturn(25);
        WeatherReporter reporter = new WeatherReporter(weatherService);
        assertEquals("Текущая температура: 25 градусов.", reporter.generateReport());
    }

    @Test
    void testIsAvailableRoom() {
        HotelService hotelService = mock(HotelService.class);
        when(hotelService.isRoomAvailable(anyInt())).thenReturn(true);
        BookingService bookingService = new BookingService(hotelService);
        assertTrue(bookingService.bookRoom(404));
    }

    @Test
    void testSendNotification() {
        MessageService msgService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(msgService);
        notificationService.sendNotification("Hello world", "user");
        verify(msgService, times(1)).sendMessage("Hello world", "user");
    }

    @Test
    void testGetDatabase() {
        Database database = mock(Database.class);
        List<String> fakeData = Arrays.asList("Data1", "Data2", "Data3");
        when(database.query(anyString())).thenReturn(fakeData);

        DataProcessor dataProcessor = new DataProcessor(database);
        List<String> result = dataProcessor.processData("Select * FROM unittest.table4");
        assertEquals(fakeData, result);

    }



}
