package ru.test.HW.dz5;

class ImageFile implements File {

    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }
}

class DocumentFile implements File {

    private String name;

    public DocumentFile(String name) {
        this.name = name;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public String getName() {
        return name;
    }
}


class PermissionChecker implements Visitor {

    @Override
    public void visit(ImageFile file) {
        System.out.println("Проверка прав доступа к файлу изображения: " + file.getName());

    }

    @Override
    public void visit(DocumentFile file) {
        System.out.println("Проверка прав доступа к файлу документа: " + file.getName());

    }
}

public class VisitorSimpleExample {
    public static void main(String[] args) {
        ImageFile image = new ImageFile("photo.jpg");
        DocumentFile document = new DocumentFile("report.docx");

        PermissionChecker checker = new PermissionChecker();

        image.accept(checker);
        document.accept(checker);
    }
}