package com.ms.api.root.msapicore.tableinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/tablemetadata")
public class TableMetadataController {

    @Autowired
    TableInfoRepository tableInfoRepository;

    private Map<String, String> getSchema() {
        return new HashMap<String, String>() {{
            put("table1", "col1:val1,col2:val2,col3:val3");
            put("table2", "col1a:val1a,col2a:val2a,col3a:val3a");
        }};
    }

    private List<TableInfo> getDummyInsertions() {
        return Arrays.asList(new TableInfo("table1X", "col1X", "val1X"),
                new TableInfo("table1X", "col2X", "val2X"),
                new TableInfo("table2X", "col1Y", "val1Y"),
                new TableInfo("table2X", "col2Y", "val2Y")
        );

    }


    @GetMapping("/greet/{name}")
    public String greeting(@PathVariable String name) {
        return "Hi!! " + name;
    }

    @GetMapping(value = {"/tables/", "/tables/{tableid}"})
    public List<TableInfo> getTableMetadata(@PathVariable(required = false) String tableid) {


        if (tableid == null || tableid.isEmpty()) {
            return tableInfoRepository.findAll();
        }

        Optional<TableInfo> tableInfoOptional = tableInfoRepository.findById(tableid);

        return tableInfoOptional.isPresent()? Arrays.asList(tableInfoOptional.get()): null;
        /*return getSchema().entrySet()
                .stream()
                .filter(e -> e.getKey().equalsIgnoreCase(tableid))
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));*/

        /*Map<String, Integer> budget = new HashMap<>();
        Map<String, Integer> sorted = budget .entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .collect( toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));*/

    }

    @GetMapping(value = "/insertion")
    public void insertionhack() {
        tableInfoRepository.saveAll(getDummyInsertions());
    }

    @PostMapping("/tables/{id}")
    public ResponseEntity<Object> addTableMetadata(@Valid @RequestBody TableInfo tableInfo) {

        tableInfoRepository.save(tableInfo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tableInfo.getColName())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
