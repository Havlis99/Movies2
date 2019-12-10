package cz.uhk.fim.movies.gui;

import cz.uhk.fim.movies.model.Movie;
import cz.uhk.fim.movies.util.FileUtils;
import cz.uhk.fim.movies.util.MovieParser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MovieListFrame extends JFrame {
    public MovieListFrame(MenuItem item) {
        initFrame(item.getName());
        initUiAndData(item.getParameter());
    }

    private void initFrame(String parameter) {
        setTitle(parameter);
        setSize(640, 480);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initUiAndData(String values) {
        JTable table = new JTable();
        MovieTableModel model = new MovieTableModel();
        List<Movie> movieList = new ArrayList<>();
        for (String s : FileUtils.decomposeCategory(values)) {
            movieList.add(MovieParser.parseMovieDetail(s));
        }
        model.setMovieList(movieList);
        table.setModel(model);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(table));
        add(tablePanel);
    }
}
