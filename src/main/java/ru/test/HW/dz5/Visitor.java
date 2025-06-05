package ru.test.HW.dz5;

interface Visitor {
    void visit(ImageFile file);
    void visit(DocumentFile file);
}