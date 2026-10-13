package org.example;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private ArrayList<Videoxogo> videoxogoList;


    public static void insertarTodo(ArrayList<Videoxogo> videoxogoList) {
        for (Videoxogo videoxogo : videoxogoList) {
            VideoxogoService.insertar(videoxogo);
        }
    }

    public static void serializar(Videoxogo videoxogo) throws IOException {
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(videoxogo.getTitulo()));
        oos.writeObject(videoxogo);
        oos.close();
    }

    public static void desSerializar(Videoxogo videoxogo) throws IOException, ClassNotFoundException {
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(videoxogo.getTitulo()));
       Videoxogo deserializado = (Videoxogo) ois.readObject();
        ois.close();
    }

    public static void transformarXML (ArrayList<Videoxogo> videoxogoList){
        for (Videoxogo videoxogo : videoxogoList) {
            try(
                    XMLOutputFactory factory = XMLOutputFactory.newInstance();
                    XMLStreamWriter writer =
                            factory.createXMLStreamWriter(new FileWriter("juegos.xml"));
            ){
                XSW.writeStartDocument();

            }
        }

    public static void main() throws IOException, ClassNotFoundException {
        List<Videoxogo> videoxogoList = new ArrayList<>();

        videoxogoList.add(new Videoxogo("The Legend of Zelda: Ocarina of Time", "Nintendo 64", "1998", "Clásico xogo de aventura e acción 3D en Hyrule"));
        videoxogoList.add(new Videoxogo("Elden Ring", "Multiplataforma", "2022", "RPG de acción desafiante nun mundo de fantasía escura."));
        videoxogoList.add(new Videoxogo("The Witcher 3: Wild Hunt", "Multiplataforma", "2015", "RPG de fantasía seguindo as aventuras do bruxo Geralt."));
        videoxogoList.add(new Videoxogo("Bloodborne", "PlayStation 4", "2015", "PG de acción e terror gótico ambientado na cidade de Yharnam."));
        videoxogoList.add(new Videoxogo("Super Mario Odyssey", "Nintendo Switch", "2017", "Plataformas 3D con mecánicas de posesión de obxectos."));

        insertarTodo((ArrayList<Videoxogo>) videoxogoList);
        for (Videoxogo videoxogo : VideoxogoService.ListarTodo()) {
            System.out.println(videoxogo.getTitulo() + videoxogo.getDescripcion());
        }

        Videoxogo v1 = VideoxogoService.listarId(1);
        System.out.println(v1.getTitulo() + v1.getDescripcion());

        serializar(v1);
        desSerializar(v1);



        VideoxogoService.eliminarTodo();
    }
}