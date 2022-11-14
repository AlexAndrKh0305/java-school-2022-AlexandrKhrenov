package ru.croc.school.task5;
import ru.croc.school.task4.Annotation;
import ru.croc.school.task4.AnnotatedImage;

class NewAnnotatedImage extends AnnotatedImage{

    NewAnnotatedImage(String imagePath, Annotation... annotations) {
        super(imagePath, annotations);
    }

    public Annotation findByPoint(double x, double y) {
        for (Annotation ann : this.getAnnotations()) {
            if (ann.getFigure().ifContainsPoint(x, y)) {
                return ann;
            }
        }
        return null;
    }

    public Annotation findByLabel(String label) {
        for (Annotation ann : this.getAnnotations()) {
            if (ann.getText().contains(label)) {
                return ann;
            }
        }
        return null;
    }

}
