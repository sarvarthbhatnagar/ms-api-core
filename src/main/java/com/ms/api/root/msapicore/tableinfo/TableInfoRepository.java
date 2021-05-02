package com.ms.api.root.msapicore.tableinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableInfoRepository extends JpaRepository<TableInfo, String> {
}
