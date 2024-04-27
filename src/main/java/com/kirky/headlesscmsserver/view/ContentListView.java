package com.kirky.headlesscmsserver.view;

import com.kirky.headlesscmsserver.dto.ContentDTO;
import com.kirky.headlesscmsserver.model.Content;
import com.kirky.headlesscmsserver.repository.ContentRepository;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("/content")
public class ContentListView extends VerticalLayout {
    private final ContentRepository contentRepository;

    public ContentListView(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
        VerticalLayout contentListVerticalLayout = getContentListVerticalLayout();
        H1 header = new H1("Content List");
        add(header, contentListVerticalLayout);
    }

    private VerticalLayout getContentListVerticalLayout() {
        VerticalLayout contentListVerticalLayout = new VerticalLayout();
        List<Content> contentList = contentRepository.findAll();
        if (!contentList.isEmpty()) {
            contentList.forEach(content -> {
                TextField textField = new TextField();
                textField.setValue(content.getTitle());
                contentListVerticalLayout.add(textField);
            });
        }

        return contentListVerticalLayout;
    }
}
