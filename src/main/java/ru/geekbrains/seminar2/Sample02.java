package ru.geekbrains.seminar2;

public class Sample02 {

    public static void main(String[] args) {

        LogReader reader = new ConcreteReaderCreator()
                .createLogReader(LogType.Poem);
        reader.setDataSource(Sample01.data);
        for (LogEntry log: reader.readLogEntry()) {
            System.out.println(log.getText());
        }

    }

}

enum LogType{
    Text,
    Poem,
    Database,
    System
}

abstract class BaseLogReaderCreator{

    public LogReader createLogReader(LogType logType){
        LogReader reader = createLogReaderInstance(logType);
        reader.setCurrentPosition(30);
        return reader;
    }

    protected abstract LogReader createLogReaderInstance(LogType logType);

}

class ConcreteReaderCreator extends BaseLogReaderCreator{

    @Override
    protected LogReader createLogReaderInstance(LogType logType) {
        return switch (logType){
            case Poem -> new PoemReader();
            case Text -> new TextFileReader();
            case Database -> new DatabaseReader();
            case System -> new  OperationSystemLogEventReader();
        };
    }
}

class TextFileReader extends LogReader{

    @Override
    public Object getDataSource() {
        return null;
    }

    @Override
    public void setDataSource(Object data) {

    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}

class DatabaseReader extends LogReader{

    @Override
    public Object getDataSource() {
        return null;
    }

    @Override
    public void setDataSource(Object data) {

    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}

class OperationSystemLogEventReader extends LogReader{

    @Override
    public Object getDataSource() {
        return null;
    }

    @Override
    public void setDataSource(Object data) {

    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}
