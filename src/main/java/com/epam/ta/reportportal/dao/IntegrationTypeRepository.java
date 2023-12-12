/*
 * Copyright 2019 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.ta.reportportal.dao;

import com.epam.ta.reportportal.entity.enums.IntegrationGroupEnum;
import com.epam.ta.reportportal.entity.integration.IntegrationType;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;

/**
 * Repository for {@link com.epam.ta.reportportal.entity.integration.IntegrationType} entity
 *
 * @author Yauheni_Martynau
 */
public interface IntegrationTypeRepository extends ReportPortalRepository<IntegrationType, Long> {

  /**
   * Find {@link IntegrationType} by id with pessimistic locking for synchronization
   *
   * @param id {@link IntegrationType#getId()}
   * @return @return The {@link Optional} of the {@link IntegrationType}
   */
  @Query(value = "SELECT it.* FROM integration_type it WHERE id = :id FOR UPDATE", nativeQuery = true)
  Optional<IntegrationType> findByIdForUpdate(@Param("id") Long id);

  /**
   * Retrieve all {@link IntegrationType} with pessimistic locking for synchronization
   *
   * @return The {@link List} of the {@link IntegrationType}
   */
  @Lock(LockModeType.PESSIMISTIC_WRITE)
  List<IntegrationType> findAllByIdOrderById();

  /**
   * Retrieve all {@link IntegrationType} by {@link IntegrationType#integrationGroup}
   *
   * @param integrationGroup {@link IntegrationType#integrationGroup}
   * @return The {@link List} of the {@link IntegrationType}
   */
  List<IntegrationType> findAllByIntegrationGroup(IntegrationGroupEnum integrationGroup);

  /**
   * Retrieve all {@link IntegrationType} ordered by {@link IntegrationType#creationDate} in
   * ascending order
   *
   * @return The {@link List} of the {@link IntegrationType}
   */
  List<IntegrationType> findAllByOrderByCreationDate();

  /**
   * Find integration by name
   *
   * @param name Integration name
   * @return @return The {@link Optional} of the {@link IntegrationType}
   */
  Optional<IntegrationType> findByName(String name);

  /**
   * Retrieve all {@link IntegrationType} by accessType
   *
   * @param accessType {@link java.lang.String}
   * @return The {@link List} of the {@link IntegrationType}
   */
  @Query(value = "SELECT it.* FROM integration_type it WHERE (it.details -> 'details'->>'accessType' = :accessType)", nativeQuery = true)
  List<IntegrationType> findAllByAccessType(@Param("accessType") String accessType);
}