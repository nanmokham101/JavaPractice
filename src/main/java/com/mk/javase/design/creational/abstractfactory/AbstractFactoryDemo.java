package com.mk.javase.design.creational.abstractfactory;
/*
    2. Abstract Factory -> in db connection we also use Statement for MySQL, Oracle more hierarchy collection of product
    good extensibility
 */
abstract class ReportHeader{
    abstract void generateHeader();
}
abstract class ReportBody{
    abstract void generateBody();
}
abstract class AbstractFactory{
    abstract ReportHeader createReportHeader();
    abstract ReportBody createReportBody();
}
class HTMLReportHeader extends ReportHeader{

    @Override
    void generateHeader() {
        System.out.println("HTML Report Header Generate");
    }
}

class HTMLReportBody extends ReportBody{

    @Override
    void generateBody() {
        System.out.println("HTML Report Body Generate");
    }
}

class PDFReportHeader extends ReportHeader{

    @Override
    void generateHeader() {
        System.out.println("PDF Report Header Generate");
    }
}

class PDFReportBody extends ReportBody{

    @Override
    void generateBody() {
        System.out.println("PDF Report Body Generate");
    }
}

class HTMLReportFactory extends AbstractFactory{

    @Override
    ReportHeader createReportHeader() {
        return new HTMLReportHeader();
    }

    @Override
    ReportBody createReportBody() {
        return new HTMLReportBody();
    }
}
class PDFReportFactory extends AbstractFactory{

    @Override
    ReportHeader createReportHeader() {
        return new PDFReportHeader();
    }

    @Override
    ReportBody createReportBody() {
        return new PDFReportBody();
    }
}
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new PDFReportFactory();
        ReportHeader header = abstractFactory.createReportHeader();
        ReportBody body = abstractFactory.createReportBody();

        header.generateHeader();
        body.generateBody();
    }
}
